$(function() {
	$('#id').blur(function() {
		var id = $('#id').val();
		var name = $('#name').val();
		
		if(id == ""){
			$('#id').val("");
			var id = $('#id').val();
		}
		
		if(id != "" || name != ""){
			$.ajax({
				datatype: "json"
      			,type: "POST"
				,url: "/admin/getDrinkName"
      			,data: $('#addForm').serialize()
				,success: function(res) {
					Object.keys(res).forEach(function(key) {
						$('#name').val(res[key]);
					});
				},error: function(res) {
					$('#name').val("");
				}
      
    		})
		}
	});
});