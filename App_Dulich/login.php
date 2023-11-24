<?php
include "connect.php";

$email = $_POST['Email'];
$matkhau = $_POST['Matkhau'];

$query = "SELECT * FROM `user` WHERE `Email`= '".$email."' AND `Matkhau` = '".$matkhau."'";
$data = mysqli_query($conn, $query);
$result = array();

while($row = mysqli_fetch_assoc($data)){
    $result[] = ($row);
}

if(!empty($result)){
    $arr = [
        'success' => true,
        'message' => "Thành công",
        'result' => $result
    ];
}else{
    $arr = [
        'success' => false,
        'message' => "Không thành công",
        'result' => $result    
    ];
}
print_r(json_encode($arr));
?>