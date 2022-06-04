jQuery(function($){
$.extend( $.fn.dataTable.defaults, {
language: {
url: "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Japanese.json"
}
});
$('#historyTable').DataTable({
	order: [[4, 'asc']]
});
});