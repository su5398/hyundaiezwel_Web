/**
 * 
 */
 
$(function(){
	parseJson();
})

function parseJson(){
	$.getJSON("json/bike.json",function(data){
		$.ajax({
			url:"bike?command=second_db",
			method:"post",
			data: {"obj":JSON.stringify(data)},
			success:function(msg){
				alert(msg);
			},
			error:function(){
				alert("data 저장 실패!");
			}
		});
	});
}