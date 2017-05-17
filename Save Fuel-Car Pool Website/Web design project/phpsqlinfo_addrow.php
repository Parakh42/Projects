<?php
  session_start();
  
  // connect to the database
  $db = mysqli_connect("localhost", "root", "", "markers");
  
  $name =         mysqli_real_escape_string($db, $_GET['name']);
  $address = mysqli_real_escape_string($db, $_GET['address']);
	$lat=		mysqli_real_escape_string($db, $_GET['lat']);

  $lng = mysqli_real_escape_string($db, $_GET['lng']);

  $type = mysqli_real_escape_string($db, $_GET['type']);

  echo $name;

$query = "INSERT INTO markers (id, name, address, lat, lng, type )
         VALUES (NULL, '$name', '$address', '$lat', '$lng', '$type')";

mysqli_query($db, $query);
$_SESSION['message'] = "dnbasjdbajks";

header("location: index.html");
  
?>