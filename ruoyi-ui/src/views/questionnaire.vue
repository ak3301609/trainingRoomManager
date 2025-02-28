<template>
    <el-container class="container-center">
        <el-header>
            <h1>实训室使用登记</h1>
        </el-header>
        <p style="color: red; padding: 0 16px; font-size: 19px; line-height: 40px;">请各位老师认真填写，填写数据将作为老师上课参照依据的一部分</p>
        <el-main>
            <el-row :gutter="15">
            <el-form ref="formData" :model="formData" :rules="rules" size="medium" label-width="100px">
                <el-col :span="24">
                <el-form-item label="日期选择" prop="date">
                    <el-date-picker v-model="formData.date" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                    :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
                </el-form-item>
                </el-col>
                <el-col :span="24">
                <el-form-item label="教师工号" prop="techerId">
                    <el-input v-model="formData.techerId" placeholder="请输入教师工号" clearable :style="{width: '100%'}">
                    </el-input>
                </el-form-item>
                </el-col>
                <el-col :span="24">
                <el-form-item label="姓名" prop="techerName">
                    <el-input v-model="formData.techerName" placeholder="请输入姓名" clearable :style="{width: '100%'}">
                    </el-input>
                </el-form-item>
                </el-col>
                <el-col :span="24">
                <el-form-item label="上课节数" prop="kejie">
                    <el-select v-model="formData.kejie" placeholder="请选择上课节数" clearable :style="{width: '100%'}">
                    <!-- <el-option v-for="(item, index) in campusptions" :key="index" :label="item.label"
                        :value="item.value" :disabled="item.disabled"></el-option> -->
                    
                      <el-option
                        v-for="dict in kejieOptions"
                        :key="dict.id"
                        :label="dict.label"
                        :value="dict.value"
                      ></el-option>
                    </el-select>
                </el-form-item>
                </el-col>
                <el-col :span="24">
                <el-form-item label="校区" prop="campusId">
                    <el-select  v-model="formData.campusId"  placeholder="请选择校区" v-on="{ change: handleChangeCampus }"
                    clearable :style="{width: '100%'}" >
                      <el-option
                        v-for="item in campusOptions"
                        :key="item.campusId"
                        :label="item.campusName"
                        :value="item.campusId"
                        :disabled="false"
                      ></el-option>
                    </el-select>
                </el-form-item>
                </el-col>
                <el-col :span="24">
                <el-form-item label="楼栋" prop="buildingId">
                    <el-select v-model="formData.buildingId" placeholder="请选择楼栋" v-on="{ change: handleChangeBuilding }"
                    clearable :style="{width: '100%'}">
                      <el-option
                        v-for="item in buildingOptions"
                        :key="item.buildingId"
                        :label="item.buildingName"
                        :value="item.buildingId"
                        :disabled="false"
                      ></el-option>
                    </el-select>
                </el-form-item>
                </el-col>
                <el-col :span="24">
                <el-form-item label="实训室" prop="roomName">
                    <el-input v-model="formData.roomName" placeholder="请输入实训室，如202" clearable :style="{width: '100%'}">
                    </el-input>
                </el-form-item>
                </el-col>
                <el-col :span="24">
                <el-form-item label="班级" prop="className">
                    <el-input v-model="formData.className" placeholder="请输入班级" clearable :style="{width: '100%'}">
                    </el-input>
                </el-form-item>
                </el-col>
                <el-col :span="24">
                <el-form-item  label="课程" prop="course">
                    <el-input v-model="formData.course" placeholder="请输入课程" clearable :style="{width: '100%'}">
                    </el-input>
                </el-form-item>
                </el-col>
                <el-col :span="23">
                <el-form-item label="故障请填写" prop="reason">
                    <el-input v-model="formData.reason" placeholder="故障请填写" clearable
                    :style="{width: '100%'}"></el-input>
                </el-form-item>
                </el-col>
                <el-col :span="24">
                <el-form-item size="large" class="item-center">
                    <el-button  type="primary" :disabled="isButtonDisabled" @click="submitForm">提交</el-button>
                    <el-button  @click="resetForm">重置</el-button>
                </el-form-item>
                </el-col>
            </el-form>
            </el-row>
        </el-main>
        <el-footer>
            <h4>信息中心提供技术支持</h4>
        </el-footer>
    </el-container> 
</template>

<script>
import { init } from "@/api/questionnaire";
import { addLog } from "@/api/system/wrongdata";
export default {
  name: "Questionnaire",
  data() {
    return {
      formData: {
        date: new Date().toISOString().slice(0, 10),
        techerId: undefined,
        techerName: undefined,
        className: undefined,
        kejie: undefined,
        campusId: undefined,
        buildingId: undefined,
        roomId: undefined,
        course: undefined,
        reason: '无',
      },
      rules: {
        date: [{
          required: true,
          message: '请选择日期选择',
          trigger: 'change'
        }],
        techerId: [{
          required: true,
          message: '请输入教师工号',
          trigger: 'blur'
        }],
        techerName: [{
          required: true,
          message: '请输入姓名',
          trigger: 'blur'
        }],
        kejie: [{
          required: true,
          message: '请选择上课节数',
          trigger: 'change'
        }],
        campusId: [{
          required: true,
          message: '请选择校区',
          trigger: 'change'
        }],
        buildingId: [{
          required: true,
          message: '请选择楼栋',
          trigger: 'change'
        }],
        roomName: [{
          required: true,
          message: '请输入实训室',
          trigger: 'change'
        }],
        className: [{
          required: true,
          message: '请选择班级',
          trigger: 'change'
        }],
        course: [{
          required: true,
          message: '请输入课程',
          trigger: 'blur'
        }],
        
      },
      // 房间信息表格数据
      roomList: [],
      // 建筑物信息
      buildingList: [],
      // 校区选项表
      campusOptions: [],
      // 建筑物选项
      buildingOptions: [],
      // 实训室选项
      roomOptions: [],
      //课节
      kejieOptions:[
        {id:1,label:'第1-2节课', value:'第1-2节课' },
        {id:2,label:'第3-4节课', value:'第3-4节课' },
        {id:3,label:'第中午1-中午2节', value:'第中午1-中午2节' },
        {id:4,label:'第5-6节课', value:'第5-6节课' },
        {id:5,label:'第7-8节课', value:'第7-8节课' },
        {id:6,label:'第9-10节课', value:'第9-10节课' },
        {id:7,label:'第11-12节课', value:'第11-12节课' },
      ],
      isButtonDisabled: false, // 表单初始化，设置为false
    }
  },
  created() {
    this.init();
  },
  methods: {
    submitForm() {
      this.$refs['formData'].validate(valid => {
        if (!valid) return
        addLog(this.formData).then(response => {
          this.$modal.msgSuccess("新增成功");
          // this.open = false;
          // this.getList();
          // this.resetForm();
          this.isButtonDisabled=true;  //设置按钮不可点击了
          this.$router.push("/welcome_success");
        });
      })
    },
    resetForm() {
      this.$refs['formData'].resetFields()
    },
    init(){
      init().then(response => {
        this.campusOptions = response.campusList;
        this.buildingList = response.buildingList;
        this.roomList = response.roomList;
      });
    },
    /** 改变校区，改变楼栋信息 */
    handleChangeCampus(){
      // console.log('改变事件触发：', this.value);
      this.formData.buildingId = undefined;
      this.formData.roomId = undefined;
      this.buildingOptions = this.buildingList.filter(item => item.campusId === this.formData.campusId);
    },
    handleChangeBuilding(){
      // console.log('改变事件触发：', this.value);
      this.formData.roomId = undefined;
      this.roomOptions = this.roomList.filter(item => item.buildingId === this.formData.buildingId);
    },
  }
}

</script>

<style>
    .container-center {
        margin: 0px auto;
        max-width: 600px;
    }

    .el-header {
        text-align: center;
        line-height: 60px;
        font-size: 22px;
    }

    .el-footer {
        text-align: center;
        line-height: 60px;
        font-size: 13px;
        color: #999;
    }

    .item-center {
        text-align: center;
    }
</style>
