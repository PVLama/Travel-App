<?php
include "connect.php";
$search = $_POST['search'];

$query = "SELECT * FROM `danhsach_diadanh` WHERE `Tendiadanh` LIKE '".$search."%' OR `Tendiadiem` LIKE '".$search."%'" ;
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