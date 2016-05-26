app.controller('SomeCtrl', function($scope) {

  $scope.shopping_list = [];

  $scope.addItem = function() {
    $scope.shopping_list.push(

        {
          "name": $scope.item_name,
          "quantity" : $scope.item_quantity
        }

      );

    $scope.item_name = "";
    $scope.item_quantity = "";
  }

})
