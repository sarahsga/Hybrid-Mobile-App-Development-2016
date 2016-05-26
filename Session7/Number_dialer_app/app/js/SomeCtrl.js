app.controller('SomeCtrl', function($scope, $timeout) {

    $scope.calc_screen = "0";
    $scope.number_list = [
        ["1","2","3"],
        ["4","5","6"],
        ["7","8","9"],
        ["*","0","#"]
      ];

 $scope.btn_click = function(i){
    console.log("jhjh")
    if ($scope.calc_screen == "0") {
      $scope.calc_screen = i;
    } else 
        $scope.calc_screen = $scope.calc_screen + "" + i;
    $timeout( function() {
      $scope.$apply();
    })


}

})
