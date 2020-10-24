let vue = new Vue({
    el: '.main-content',
    data: {
        pageinfo: {},
        qualification: {
        },
        qualificationCondition:{
          type:"",
          check:"",
          firstDate:"",
          lastDate:""
        },
        active:true
    },
    methods: {
        getQualificationAll: function (pageNum=1, pageSize=3) {
            axios({
                url: `manager/qualification/getQualificationAll/${pageNum}/${pageSize}`,
                method: "get",
                params: this.qualificationCondition
            }).then(
                response => {
                    this.pageinfo = response.data.obj
                    this.qualificationCondition={}
                }
            ).catch(error => {
                console.log(error.message);
            })
        },
        detail:function (qualification) {
            layer.obj = qualification;
            layer.open({
                type: 2,
                title: '详细情况',
                area: ['80%', '80%'],
                content: 'manager/demand/toDetail',
                end:  ()=> {
                }
            })
        },
        layertoupdate: function (qualification) {
            layer.obj = qualification;
            layer.open({
                type: 2,
                title: '更新',
                area: ['80%', '80%'],
                content: 'manager/qualification/toUpdate',
                end:  ()=> {
                    this.getQualificationAll();
                }
            })
        },
        clearAndGetAll:function(){
           this.qualificationCondition={}
           this.getQualificationAll();
        },
        deleteById: function (qualification) {
            layer.confirm('确定要删除?', {
                btn: ['确定', '不要']
            },  ()=> {
                qualification.delFlag="1";
                axios({
                    url: 'manager/qualification/updateQualificationById',
                    method: "post",
                    data: qualification,
                    headers: {'Content-Type': 'application/json;charset=utf-8'}
                }).then(
                    response => {
                        layer.msg(response.data.msg, {icon: 1})
                        this.getQualificationAll();
                    }
                ).catch(error => {
                    console.log(error.message);
                });
            },  ()=> {
            });
        },
    },
    clear: function () {
        this.demand = {};//清空属性数据
    },
    created: function () {
        this.getQualificationAll();
    }
});
