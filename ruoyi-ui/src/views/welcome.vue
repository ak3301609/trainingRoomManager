<template>
  <el-container style="height: 100vh; display: flex; justify-content: center; align-items: center; background-color: #f5f7fa;">
    <el-main class="main-content">
      <el-card class="box-card" :body-style="{ padding: '40px' }">
        <div class="text-center">
          <h1 style="color: #409EFF; margin-bottom: 20px;">教师节快乐</h1>
          <p>亲爱的老师们，</p>
          <p>在这个特别的日子里，学校向您表达最深切的敬意和感谢。</p>
          <p>感谢您的辛勤工作和无私奉献，您是学生成长道路上的引路人。</p>
          <p>祝您教师节快乐，身体健康，工作顺利！</p>
          <!-- <el-button type="primary" class="btn" @click="moreBlessings">更多祝福</el-button> -->
        </div>
      </el-card>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'TeacherDay',
  methods: {
    moreBlessings() {
      // 这里可以添加点击按钮后的操作，比如打开一个新的页面或弹窗
      console.log('查看更多祝福');
    }
  }
};
</script>

<style scoped>
.main-content {
  width: 50%;
  text-align: center;
}

.box-card {
  background-color: white;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
  overflow: hidden;
}

.text-center {
  text-align: center;
}

.btn {
  margin-top: 20px;
  background: linear-gradient(to right, #409EFF, #66b1ff);
  border: none;
  color: white;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.btn:hover {
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

h1 {
  font-size: 2em;
  font-weight: bold;
}

p {
  font-size: 1.2em;
  color: #606266;
}

.el-icon-gift {
  font-size: 3em;
  color: #409EFF;
}
</style>