app.factory('websiteFactory', function($http) {
	return {
		getTop: function(from, to, limit) {
			console.log('top called');
			return $http({
		        method : "GET",
		        url : "/top",
		        headers: {
		        	   'Content-Type': 'application/json'
	        	 },
		        params: { from: from, to: to, limit: limit }
		    });
		},
		clear: function() {
			return $http({
				method: "POST",
				url: '/clear'
			});
		}
	}
});