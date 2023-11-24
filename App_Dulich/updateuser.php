<?php
include "connect.php";
$tendangnhap = $_POST['Tendangnhap'];
$oldemail = $_POST['Email'];
$sodienthoai = $_POST['Sodienthoai'];
$matkhau = $_POST['Matkhau'];


// check data;
$query = "SELECT * FROM `user` WHERE `Email` = '$oldemail' "  ;
$data = mysqli_query($conn, $query);
$numrow = mysqli_num_rows($data); 

if($numrow > 0){
    $que = "UPDATE `user` SET `Tendangnhap`='$tendangnhap',`Sodienthoai`='$sodienthoai',`Matkhau`='$matkhau' WHERE `Email`='$oldemail' ";
    $data = mysqli_query($conn, $que);
    if($data == true){
        $arr = [
            'success' => true,
            'message' => "Thành công"
        ];
    }else{
        $arr = [
            'success' => false,
            'message' => "Không thành công"
        ];
    }
}
print_r(json_encode($arr));
?>
