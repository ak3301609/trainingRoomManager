<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="房间名称" prop="roomName">
        <el-input
          v-model="queryParams.roomName"
          placeholder="请输入房间名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="校区" prop="campusId">
        <el-select v-model="queryParams.campusId" placeholder="请选择校区" v-on="{ change: handleFormChangeCampus }" clearable>
          <el-option
            v-for="item in campusOptions"
            :key="item.campusId"
            :label="item.campusName"
            :value="item.campusId"
            :disabled="false"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="建筑物" prop="buildingId">
        <el-select v-model="queryParams.buildingId" placeholder="请选择建筑物" clearable>
          <el-option
            v-for="item in formBuildingOptions"
            :key="item.buildingId"
            :label="item.buildingName"
            :value="item.buildingId"
            :disabled="false"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:room:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:room:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:room:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:room:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="roomList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="房间ID" align="center" prop="roomId" />
      <el-table-column label="房间名称" align="center" prop="roomName" />
      <el-table-column label="校区" align="center" prop="sysCampus.campusName" />
      <el-table-column label="建筑物" align="center" prop="sysBuilding.buildingName" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:room:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:room:remove']"
          >删除</el-button>
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

    <!-- 添加或修改房间信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="房间名称" prop="roomName">
          <el-input v-model="form.roomName" placeholder="请输入房间名称" />
        </el-form-item>
        <el-form-item label="校区" prop="campusId">
          <el-select v-model="form.campusId" placeholder="请选择校区" v-on="{ change: handleChangeCampus }">
            <el-option
              v-for="item in campusOptions"
              :key="item.campusId"
              :label="item.campusName"
              :value="item.campusId"
              :disabled="false"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="建筑物" prop="buildingId">
          <el-select v-model="form.buildingId" placeholder="请选择建筑物">
            <el-option
              v-for="item in buildingOptions"
              :key="item.buildingId"
              :label="item.buildingName"
              :value="item.buildingId"
              :disabled="false"
            ></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="删除标志" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入删除标志" />
        </el-form-item> -->
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listRoom, getRoom, delRoom, addRoom, updateRoom } from "@/api/system/room";

export default {
  name: "Room",
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
      // 房间信息表格数据
      roomList: [],
      // 建筑物信息
      buildingList: [],
      // 校区选项
      campusOptions: [],
      // 建筑物选项
      buildingOptions: [],
      // 建筑物选项
      formBuildingOptions: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        roomName: null,
        campusId: null,
        buildingId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        roomName: [
          { required: true, message: "房间名称不能为空", trigger: "blur" }
        ],
        campusId: [
          { required: true, message: "校区id不能为空", trigger: "blur" }
        ],
        buildingId: [
          { required: true, message: "建筑物id不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  mounted() {
    this.getCampusAndBuildingList();
  },
  methods: {
    /** 查询房间信息列表 */
    getList() {
      this.loading = true;
      listRoom(this.queryParams).then(response => {
        this.roomList = response.rows;
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
        roomId: null,
        roomName: null,
        campusId: null,
        buildingId: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
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
      this.ids = selection.map(item => item.roomId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      getRoom().then(response => {
        this.campusOptions = response.campusList;
        this.buildingList = response.buildingList;
        this.open = true;
        this.title = "添加实训室";
      });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const roomId = row.roomId || this.ids
      getRoom(roomId).then(response => {
        this.form = response.data;
        this.campusOptions = response.campusList;
        this.buildingList = response.buildingList;
        this.buildingOptions = this.buildingList.filter(item => item.campusId === this.form.campusId);
        this.open = true;
        this.title = "修改实训室";
      });
    },
    /**初始化校区列表 和 建筑物列表 */
    getCampusAndBuildingList(){
      getRoom().then(response => {
        this.campusOptions = response.campusList;
        this.buildingList = response.buildingList;
      });
    },
    /** 改变校区，改变楼栋信息 */
    handleChangeCampus(){
      // console.log('改变事件触发：', this.value);
      this.buildingOptions = this.buildingList.filter(item => item.campusId === this.form.campusId);

    },
    /** 改变校区，改变楼栋信息 查询条件 */
    handleFormChangeCampus(){
      // console.log('改变事件触发：', this.value);
      this.formBuildingOptions = this.buildingList.filter(item => item.campusId === this.queryParams.campusId);

    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.roomId != null) {
            updateRoom(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRoom(this.form).then(response => {
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
      const roomIds = row.roomId || this.ids;
      this.$modal.confirm('是否确认删除房间信息编号为"' + roomIds + '"的数据项？').then(function() {
        return delRoom(roomIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/room/export', {
        ...this.queryParams
      }, `room_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
