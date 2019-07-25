app.controller('brandController',function($scope,$http,brandService,$controller){
    $controller('baseController',{$scope:$scope});
    $scope.findAll = function(){
        brandService.findAll().success(function (res) {
            $scope.brandList = res;
        })
    };

    $scope.findPage=function(page,size){
        brandService.findPage(page,size).success(
            function(response){
                $scope.brandList=response.rows;
                //更新总记录数
                $scope.paginationConf.totalItems=response.total;
            }
        );
    };

    //对应后台接受的实体类
    $scope.entity = {};
    $scope.save = function () {
        //发送保存请求，接受返回值并重新刷新界面
        brandService.save($scope.entity).success(function (res) {
            //提示客户
            alert(res.message);
            //如果成功，刷新界面
            if(res.success){
                $scope.reloadList();
            }
        })
    };
    $scope.findOne = function (id) {
        brandService.findOne(id).success(function (res) {
            $scope.entity = res;
        })
    };

    $scope.delete = function () {
        brandService.delete($scope.selectIds).success(function (res) {
            alert(res.message);
            if (res.success){
                $scope.reloadList();
                $scope.selectIds = [];
            }
        })
    }
});