<?php
include "connect.php";
$tendangnhap = $_POST['Tendangnhap'];
$email = $_POST['Email'];
$sodienthoai = $_POST['Sodienthoai'];
$matkhau = $_POST['Matkhau'];

// check data;
$query = "SELECT * FROM `user` WHERE `Email` = '".$email."' "  ;
$data = mysqli_query($conn, $query);
$numrow = mysqli_num_rows($data); 

if($numrow > 0){
    $arr = [
        'success' => false,
        'message' => "Email đã tồn tại"
    ];
}
else{
            $query = "INSERT INTO `user`( `Tendangnhap`, `Email`, `Sodienthoai`, `Matkhau`) VALUES ('".$tendangnhap."','".$email."','".$sodienthoai."','".$matkhau."')";
            $data = mysqli_query($conn, $query);

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