angular.module('myApp',[]).controller('ctrlMain', function($scope, $http) {
    var url = 'rest/valores/';

    $scope.valores = [];

	$scope.getValores = function(dependentes, salario) {
		if (salario == undefined) {
			alert("Preencha o campo Salário.")
		} else
		if (dependentes == undefined) {
			alert("Preencha o campo Dependentes.")
		} else {
			$http({
				method : 'GET',
				url : url + dependentes + '/' + salario
			}).then(function(response) {
				console.log('Sucesso metodo getValores.');
				$scope.valores = response.data;
			}, function(response) {
				console.log('Erro metodo getValores.');
				console.log(response.data);
			});
		}
	};
});