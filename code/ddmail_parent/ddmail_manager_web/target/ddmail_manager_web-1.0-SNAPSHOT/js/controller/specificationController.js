app.controller('specificationController',function($scope,$http,specificationService,$controller){
    $controller('baseController',{$scope:$scope});
    $scope.findAll = function(){
        specificationService.findAll.success(function (res) {
            $scope.specificationList = res;
        })
    };

    $scope.findPage=function(page,size){
        specificationService.findPage(page,size).success(
            function(response){
                $scope.specificationList=response.rows;
                //更新总记录数
                $scope.paginationConf.totalItems=response.total;
            }
        );
    };

    //对应后台接受的实体类
    $scope.entity = {spec:{},optionList:[]};
    $scope.save = function () {
        //发送保存请求，接受返回值并重新刷新界面
        specificationService.save($scope.entity).success(function (res) {
            //提示客户
            alert(res.message);
            //如果成功，刷新界面
            if(res.success){
                $scope.reloadList();
            }
        })
    };
    $scope.findOne = function (id) {
        specificationService.findOne(id).success(function (res) {
            $scope.entity = res;
        })
    };

    $scope.delete = function () {
        specificationService.delete($scope.selectIds).success(function (res) {
            alert(res.message);
            if (res.success){
                $scope.reloadList();
                $scope.selectIds = [];
            }
        })
    };

    //插入一行
    $scope.insertRow = function () {
        $scope.entity.optionList.push({});
    };
    $scope.deleteRow = function (option) {
        var index = $scope.entity.optionList.indexOf(option);
        $scope.entity.optionList.splice(index, 1);
    };

});