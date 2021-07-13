<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loans</title>


<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<style>
.grid-container {
  display: grid;
  grid-template-columns: auto auto;
  grid-row-gap: 70px;
  grid-column-gap: 70px;
  background-image: url("money-background-loan.jpg");
  
  /*background-color: #2196F3;*/
  padding: 10px;
  
}

.grid-container > div {
  background-color: rgba(255, 255, 255, 0.8);
  text-align: center;
  /*padding: 20px 0;*/
  font-size: 30px;
}

.item1 {
  grid-row: 1 / span 1;

}



.flip-card {
  background-color: transparent;
  width: 100%;
  height: 300px;
  perspective: 1000px;
}

.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.6s;
  transform-style: preserve-3d;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
}

.flip-card:hover .flip-card-inner {
  transform: rotateY(180deg);
}

.flip-card-front, .flip-card-back {
  position: absolute;
  width: 100%;
  height: 100%;
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
}

.flip-card-front {
  background-color: #bbb;
  color: black;
}

.flip-card-back {
  background-color: #2980b9;
  color: white;
  transform: rotateY(180deg);
}

</style>

</head>
<body>



<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="#">KARNATAKA BANK</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="index.html">Home</a>
      </li> 
    </ul>
  </div>  
</nav>



<div class="grid-container">
  <div class="item1">
  
  <div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
      <img src="personal-loan.jfif" alt="Personal Loan" style="width:100%;height:300px;">
    </div>
    <div class="flip-card-back">
      <h1 style="padding-top: 10%;">PERSONAL LOAN</h1> 
      <p>@ 9.60% p.a.</p> 
      <p>0% Processing Fee and other attractive benefits</p>
    </div>
  </div>
</div>

  </div>
  
  <div class="item2">
  
  <div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
      <img src="business-loan.jfif" alt="Business Loan" style="width:100%;height:300px;">
    </div>
    <div class="flip-card-back">
      <h1 style="padding-top: 10%;">BUSINESS LOAN</h1> 
      <p>Faster <span>&#183;</span> Smarter <span>&#183;</span> Flexible</p>
      <p>for micro, small, medium and large enterprises</p> 
      
    </div>
  </div>
</div>
  
  </div>
  <div class="item3">
  
  <div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
      <img src="home-loan.jfif" alt="Home Loan" style="width:100%;height:300px;">
    </div>
    <div class="flip-card-back">
      <h1 style="padding-top: 10%;">HOME LOAN @ 7.15%</h1> 
      <p>Lowest EMI per Lac <span>&#x20B9;</span> 874</p> 
      <p>Faster Approval</p>
    </div>
  </div>
</div>
  
  </div>  
  
  <div class="item4">
  
  <div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
      <img src="edu-loan.jfif" alt="Education Loan" style="width:100%;height:300px;">
    </div>
    <div class="flip-card-back">
      <h1 style="padding-top: 10%;">EDUCATION LOAN</h1> 
      <p>Interest Rate 7.20% p.a. onwards</p>
      <p>100% Financing for any course</p> 
    </div>
  </div>
</div>
  
  </div>
  
  <div class="item5">
  
  <div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
      <img src="gold-loan.jfif" alt="Gold Loan" style="width:100%;height:300px;">
    </div>
    <div class="flip-card-back">
      <h1 style="padding-top: 10%;">GOLD LOAN</h1> 
      <p>First 100 customers will get <span>&#x20B9;</span> 500 Cashback</p> 
      <p>Get quicker loan disbursal</p>
    </div>
  </div>
</div>
  
  </div>
  
  <div class="item6">
  
  <div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
      <img src="car-loan.jpg" alt="Car Loan" style="width:100%;height:300px;">
    </div>
    <div class="flip-card-back">
      <h1 style="padding-top: 10%;">CAR LOAN</h1> 
      <p>WALK IN. DRIVE OUT.</p> 
      <p>OFFERS UP TO <span>&#x20B9;</span> 95,000* | 100% FUNDING</p>
    </div>
  </div>
</div>
  
  </div>

  
</div>

</body>
</html>