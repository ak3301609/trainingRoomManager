<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="教工号" prop="techerId">
        <el-input
          v-model="queryParams.techerId"
          placeholder="请输入教工号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="教职工名称" prop="techerName">
        <el-input
          v-model="queryParams.techerName"
          placeholder="请输入教职工名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实训室详细地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入实训室详细地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="reason">
        <el-input
          v-model="queryParams.reason"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="登记时间" prop="date">
        <el-date-picker clearable
          v-model="queryParams.date"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择登记时间">
        </el-date-picker>
      </el-form-item> -->
      <el-form-item label="登记时间">
        <el-date-picker
          v-model="dateRange"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="班级名称" prop="className">
        <el-input
          v-model="queryParams.className"
          placeholder="请输入班级名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课节" prop="kejie">
        <el-input
          v-model="queryParams.kejie"
          placeholder="请输入课节"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="校区id" prop="campusId">
        <el-input
          v-model="queryParams.campusId"
          placeholder="请输入校区id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="楼栋id" prop="buildingId">
        <el-input
          v-model="queryParams.buildingId"
          placeholder="请输入楼栋id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实训室id" prop="roomId">
        <el-input
          v-model="queryParams.roomId"
          placeholder="请输入实训室id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="课程" prop="course">
        <el-input
          v-model="queryParams.course"
          placeholder="请输入课程"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <!-- <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:log:add']"
        >新增</el-button>
      </el-col> -->
      <!-- <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:log:edit']"
        >修改</el-button>
      </el-col> -->
      <!-- <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:log:remove']"
        >删除</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:log:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="logList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="登记信息ID" align="center" prop="wrongdataId" />
      <el-table-column label="教工号" align="center" prop="techerId" />
      <el-table-column label="教职工名称" align="center" prop="techerName" />
      <el-table-column label="实训室详细地址" align="center" prop="address" />
      <el-table-column label="备注" align="center" prop="reason" />
      <el-table-column label="登记时间" align="center" prop="date" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.date, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="教学周" align="center" prop="schoolWeek" />
      <el-table-column label="星期" align="center" prop="week" />
      <el-table-column label="班级名称" align="center" prop="className" />
      <el-table-column label="课节" align="center" prop="kejie" />
      <!-- <el-table-column label="校区id" align="center" prop="campusId" />
      <el-table-column label="楼栋id" align="center" prop="buildingId" />
      <el-table-column label="实训室id" align="center" prop="roomId" /> -->
      <el-table-column label="课程" align="center" prop="course" />
      <el-table-column label="是否处理" align="center" prop="done">
        <template slot-scope="scope">
          <span>{{ getDoneName(scope.row.done) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:log:edit']"
          >修改</el-button> -->
          <!-- <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:log:remove']"
          >删除</el-button> -->

          <!-- 在此增加处理按钮 -->

          <el-button
            v-if="scope.row.done == 1"
            size="mini"
            type="text"
            icon="el-icon-circle-check"
            @click="handleUpdateDone(scope.row.wrongdataId)"
            v-hasPermi="['system:log:edit']"
            >已处理</el-button>

        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改实训室登记记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="教工号" prop="techerId">
          <el-input v-model="form.techerId" placeholder="请输入教工号" />
        </el-form-item>
        <el-form-item label="教职工名称" prop="techerName">
          <el-input v-model="form.techerName" placeholder="请输入教职工名称" />
        </el-form-item>
        <el-form-item label="实训室详细地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入实训室详细地址" />
        </el-form-item>
        <el-form-item label="备注" prop="reason">
          <el-input v-model="form.reason" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="登记时间" prop="date">
          <el-date-picker clearable
            v-model="form.date"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择登记时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="班级名称" prop="className">
          <el-input v-model="form.className" placeholder="请输入班级名称" />
        </el-form-item>
        <el-form-item label="课节" prop="kejie">
          <el-input v-model="form.kejie" placeholder="请输入课节" />
        </el-form-item>
        <el-form-item label="校区id" prop="campusId">
          <el-input v-model="form.campusId" placeholder="请输入校区id" />
        </el-form-item>
        <el-form-item label="楼栋id" prop="buildingId">
          <el-input v-model="form.buildingId" placeholder="请输入楼栋id" />
        </el-form-item>
        <el-form-item label="实训室id" prop="roomId">
          <el-input v-model="form.roomId" placeholder="请输入实训室id" />
        </el-form-item>
        <el-form-item label="课程" prop="course">
          <el-input v-model="form.course" placeholder="请输入课程" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listLog, getLog, delLog, addLog, updateLog } from "@/api/system/wrongdata";

export default {
  name: "Log",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 实训室登记记录表格数据
      logList: [],
      // 日期范围
      dateRange: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        techerId: null,
        techerName: null,
        address: null,
        reason: null,
        date: null,
        done: null,
        className: null,
        kejie: null,
        campusId: null,
        buildingId: null,
        roomId: null,
        course: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        techerId: [
          { required: true, message: "教工号不能为空", trigger: "blur" }
        ],
        techerName: [
          { required: true, message: "教职工名称不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "实训室详细地址不能为空", trigger: "blur" }
        ],
        reason: [
          { required: true, message: "备注不能为空", trigger: "blur" }
        ],
        date: [
          { required: true, message: "登记时间不能为空", trigger: "blur" }
        ],
        done: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ],
        className: [
          { required: true, message: "班级名称不能为空", trigger: "blur" }
        ],
        kejie: [
          { required: true, message: "课节不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询实训室登记记录列表 */
    getList() {
      this.loading = true;
      listLog(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        this.logList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        wrongdataId: null,
        techerId: null,
        techerName: null,
        address: null,
        reason: null,
        date: null,
        done: null,
        className: null,
        kejie: null,
        campusId: null,
        buildingId: null,
        roomId: null,
        course: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.wrongdataId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加实训室登记记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const wrongdataId = row.wrongdataId || this.ids
      getLog(wrongdataId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改实训室登记记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.wrongdataId != null) {
            updateLog(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLog(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const wrongdataIds = row.wrongdataId || this.ids;
      this.$modal.confirm('是否确认删除实训室登记记录编号为"' + wrongdataIds + '"的数据项？').then(function() {
        return delLog(wrongdataIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/log/wrongdata/export', {
        ...this.queryParams
      }, `log_${new Date().getTime()}.xlsx`)
    },
    /**根据状态显示不同中文名称 */
    getDoneName(done) {
      if (done == 0) {
        return "无";
      } else if (done == 1) {
        return "未处理";
      } else if (done == 2) {
        return "已处理";
      }else {
        return "错误状态";
      }
    },
    handleUpdateDone(wrongdataId) {
      this.form = { wrongdataId: wrongdataId, done: 2};
      updateLog(this.form);
      this.$modal.msgSuccess("处理成功！");
      this.getList();
    },
  }
};
</script>
