function  addProduct(ID, productName, price, unit) {
  var ID = ID;
  var productName = productName;
  var price = price;
  var unit = unit;
  $( "#inputProducts" ).append( "<tr><td><input type='text' name='idProduct[]' value='"+ID+"' style='width:50px;' readonly></td>" +
    "<td>"+productName+"</td>" +
    "<td><input type='text' name='price[]' value='"+price+"' style='width: 100px;' readonly></td>"+
    "<td>"+unit+"</td>" +
    "<td><input type='number' required name='quantity[]' style='width: 50px; onchange='ChangeValue2(this.value)'></td>" +
    "<td><p onclick='DeleteRow(this)' title='Xóa dòng'><i class='fas fa-trash-alt'></i></p></td>"+
    "</tr>" );
}
function DeleteRow(e) {
  $(e).parent().parent().remove();
}
