$(function() {

	$("#queryBtn").on("click", function() {
		console.info("fid = %s", $("#fid").val());
		$.getJSON("film-query", { 
			fid: $("#fid").val()

		}).done(function(result) {
			for (var i in result)
				$("#" + i).text(result[i]);

		}).fail(function(err) {
			console.info(">>> %s", JSON.stringify(err));

		}).always(function() {
			$("#fid").val("");
		})
	})

});

