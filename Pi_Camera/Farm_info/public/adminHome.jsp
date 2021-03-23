<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.html"%>
<!DOCTYPE html>
<html>
<title>果園守衛系統</title>
<body>
<center><img src="dgi.png" width="338" height="100">
<img src="apj sir.png" align="right"  width="100" height="100"></center>
<div class="w3-container">
  <div class="w3-bar w3-black">
    <button class="w3-bar-item w3-button tablink w3-red" onclick="openCity(event,'Tokyo')">Registered Students</button>
     <button class="w3-bar-item w3-button tablink" onclick="openCity(event,'Tokyo1')">All Student Result</button>
     <a href="adminLogin.jsp" class="w3-bar-item w3-button tablink">登出
     </a>
  </div>
  
  
  <div id="Tokyo" class="w3-container w3-border city">
  
<section>
  <!--for demo wrap-->
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
         <th>Course Name</th>
          <th>Branch Name</th>
          <th>Roll Number</th>
          <th>Name</th>
          <th>Father Name</th>
          <th>Gender</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
        <tr>
          <td>B.Tech</td>
          <td>CSE</td>
          <td>10025</td>
          <td>Gaurav kumar</td>
          <td>Sunil Kumar</td>
          <td>Male</td>
        </tr>

      </tbody>
    </table>
  </div>
</section>
</div>
<div id="Tokyo1" class="w3-container w3-border city" style="display:none">
   
<section>
  <!--for demo wrap-->
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Roll Number</th>
          <th>Engg. Physics-I</th>
          <th>Engg. Chemistry</th>
          <th>Engg. Mathematics-I</th>
          <th>Basic Electrical Engg</th>
          <th>Electronic Engg.</th>
          <th>Engg. Chemistry Lab</th>
          <th>Engg. Physics Lab</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
        <tr>
          <td>10025</td>
          <td>70</td>
          <td>80</td>
          <td>90</td>
          <td>50</td>
          <td>56</td>
          <td>25</td>
          <td>25</td>
        </tr>
      </tbody>
    </table>
  </div>
</section>

</div>
    <hr class="new1">
  <center><h5>Note: Any errors occur then contact BTech Days.
Designed & Developed by BTech Days Team</h5></center>
  <hr class="new1">
<center><h5>All Right Reserved @ BTech Days :: 2015-2020</h5></center> 
  <hr class="new1">
<br>
</body>
</html>