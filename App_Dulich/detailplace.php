<?php
include "connect.php";

$query = "SELECT * FROM `danhsach_diadanh` ";   
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