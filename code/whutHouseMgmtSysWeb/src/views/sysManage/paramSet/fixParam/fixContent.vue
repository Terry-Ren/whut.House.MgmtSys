<template>
  <div class="third-container">
    <!-- 面包屑导航 -->
    <div class="warp-breadcrum">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>维修参数</el-breadcrumb-item>
        <el-breadcrumb-item>维修内容</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbar">
        <el-form :inline="true" style="margin-bottom:15px">
          <el-button type="primary" @click="addFormVisible = true">新增内容</el-button>
        </el-form>
      </div>
      <!-- 表格区 -->
      <div class="main-data">
        <el-table class="table" :data="fixType" v-loading="listLoading" height="string">
          <el-table-column type="selection" width="55"></el-table-column>
          <el-table-column type="index" width="65" label="序号" style="text-aligin:center" align="center"></el-table-column>
          <el-table-column prop="fixParamName" label="维修内容" sortable align="center"></el-table-column>
          <el-table-column label="操作" width="200" align="center">
            <template slot-scope="scope">
              <el-button size="small" @click="showModifyDialog(scope.$index,scope.row)">编辑</el-button>
              <el-button type="danger" size="small" @click="delectLayout(scope.$index,scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent"
        :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
      </el-pagination>
    </div>
    <!-- 新增表单 -->
    <el-dialog title="新增维修内容" class="paramDialog" :visible.sync="addFormVisible" v-loading="submitLoading">
      <el-form :model="addFormBody" label-width="100px" ref="addForm" :rules="rules" auto>
        <el-row>
          <el-col :span="20">
            <el-form-item label="维修内容" prop="fixParamName">
              <el-input v-model="addFormBody.fixParamName" placeholder="请输入维修内容"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native=" addFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="addSubmit">提交</el-button>
      </div>
    </el-dialog>

    <!-- 编辑表单 -->
    <el-dialog title="编辑维修内容" class="paramDialog" :visible.sync="modifyFormVisible" v-loading="modifyLoading">
      <el-form :model="modifyFromBody" label-width="100px" ref="modifyFrom" :rules="rules">
        <el-row>
          <el-col :span="20">
            <el-form-item label="维修内容" prop="fixParamName">
              <el-input v-model="modifyFromBody.fixParamName" placeholder="请输入维修内容"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native=" modifyFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="modifySubmit">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
  import {
    getFixParam,
    deleteFixParam,
    postFixParam,
    putFixParam
  } from '@/api/sysManage'
  import utils from '@/utils/index.js'
  export default {
    data() {
      return {
        paramClass: 16,
        // 表格数据
        fixType: [],
        listLoading: false,
        totalNum: 0,
        page: 1,
        size: 10,

        // 表单规则验证
        rules: {
          fixParamName: {
            required: true,
            message: '维修内容不能为空',
            trigger: 'blur'
          },
        },

        //编辑表单相关数据
        modifyFormVisible: false,
        modifyLoading: false,
        modifyFromBody: {
          fixParamName: ''
        },

        // 新增表单相关数据
        submitLoading: false,
        addFormVisible: false,
        addFormBody: {
          fixParamName: ''
        }
      }

    },
    mounted() {
      this.getList()
    },
    methods: {
      // 获取房屋户型
      getList() {
        this.listLoading = true
        let param = {
          page: this.page,
          size: this.size
        }
        // http请求
        getFixParam(param, this.paramClass).then((res) => {
          this.fixType = res.data.data.data.list
          this.totalNum = res.data.data.data.total
          this.listLoading = false
        }).catch((err) => {
          console.log(err)
        })
      },
      // 删除功能
      delectLayout(index, row) {
        this.$confirm('此操作将删除该维修内容', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let param = row.fixParamId
          this.listLoading = true
          deleteFixParam(param).then((res) => {
            // 公共提示方法
            utils.statusinfo(this, res.data)
            this.getList()
          }).catch((err) => {
            console.log(err)
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      // 新增提交
      addSubmit() {
        this.$refs['addForm'].validate((valid) => {
          if (valid) {
            this.submitLoading = true
            let param = Object.assign({}, this.addFormBody)
            param.paramTypeId = this.paramClass
            postFixParam(param).then((res) => {
              // 公共提示方法
              utils.statusinfo(this, res.data)
              this.$refs['addForm'].resetFields()
              this.submitLoading = false
              this.addFormVisible = false
              this.getList()
            })
          }
        })
      },
      //显示编辑
      showModifyDialog(index, row) {
        this.modifyFormVisible = true
        this.modifyFromBody = Object.assign({}, row)
        this.selectRowIndex = index
        //console.log(this.selectRowIndex)
      },
      //编辑提交
      modifySubmit() {
        this.$refs['modifyFrom'].validate((valid) => {
          if (valid) {
            this.modifyLoading = true
            let param = Object.assign({}, this.modifyFromBody)
            putFixParam(param).then((res) => {
              utils.statusinfo(this, res.data)
              this.modifyLoading = false
              this.modifyFormVisible = false
              this.getList()
            })
          }
        })
      },
      //更换每页数量
      SizeChangeEvent(val) {
        this.size = val;
        this.getList()
      },
      //页码切换时
      CurrentChangeEvent(val) {
        this.page = val;
        this.getList();
      }
    }
  }

</script>

<style scoped lang="scss">


</style>
