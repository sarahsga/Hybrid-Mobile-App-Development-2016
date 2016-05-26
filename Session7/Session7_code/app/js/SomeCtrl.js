app.controller('SomeCtrl', function($scope) {

  $scope.student_list = [

      {'roll_number': 'SE-01', 'marks' : 43 , 'grade':'B'},
      {'roll_number': 'SE-02', 'marks' : 23 , 'grade':'D'},
      {'roll_number': 'SE-03', 'marks' : 54 , 'grade':'A'},
      {'roll_number': 'SE-04', 'marks' : 34 , 'grade':'C'},
      {'roll_number': 'SE-05', 'marks' : 23 , 'grade':'D'},
      {'roll_number': 'SE-06', 'marks' : 44 , 'grade':'B'},


      ]

  $scope.item_name = "";
  $scope.item_quantity = "";

  $scope.num_list = [1,2,3,4,5,6,7,8,9,10];

  $scope.shopping_list = [

  ]

  $scope.addItem = function() {
    console.log("hello world")
    $scope.shopping_list.push(
        {
          "item_name": $scope.item_name,
          "item_quantity": $scope.item_quantity
        }
      )

    $scope.item_name = "";
    $scope.item_quantity = "";
  }


})
