<!doctype html>
<html lang="en">
  <head>
    <title>BÁNH SINH NHẬT TRANG TRÍ ĐẸP
    </title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/trangchu.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  <body>
      <header class="header">
         
         <nav class="navbar navbar-expand-sm navbar-light bg-light ">
             <div class="container">
             <a class="navbar-brand" href="#"><img class= "logo" src="img/logo-giao-banh-nhanh.png" alt=""> </a>
             <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
                 aria-expanded="false" aria-label="Toggle navigation">
                 <span class="navbar-toggler-icon"></span>
             </button>
             <div class="collapse navbar-collapse" id="collapsibleNavId">
                 <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                     <li class="nav-item active">
                         <a class="nav-link" href="/home">Trang chủ <span class="sr-only">(current)</span></a>
                     </li>
                     <li class="nav-item">
                         <a class="nav-link" href="/gioithieu">Giới thiệu </a>
                     </li>
                     <li class="nav-item dropdown">
                         <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" 
                            aria-haspopup="true" aria-expanded="false">Mẫu bánh </a>
                         <div class="dropdown-menu" aria-labelledby="dropdownId">
                             <a class="dropdown-item"th:each="productType :${prodctTypeListActive}" th:href="@{/category(categoryId=${productType.productTypeId})}" th:text="${productType.productTypeName}" ></a>
                         </div>
                     </li>
                     <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" 
                           aria-haspopup="true" aria-expanded="false">Con giáp </a>
                        <div class="dropdown-menu" aria-labelledby="dropdownId">
                            <a class="dropdown-item" href="#">Bánh sinh nhật hình con chuột</a>
                            <a class="dropdown-item" href="#">Bánh sinh nhật hình con trâu</a>
                            <a class="dropdown-item" href="#">Bánh sinh nhật hình con hổ</a>
                            <a class="dropdown-item" href="#">Bánh sinh nhật hình con mèo</a>
                            <a class="dropdown-item`" href="#">Bánh sinh nhật hình con rồng</a>
                            <a class="dropdown-item" href="#">Bánh sinh nhật hình con rắn</a>
                            <a class="dropdown-item" href="#">Bánh sinh nhật hình con ngựa</a>
                            <a class="dropdown-item" href="#">Bánh sinh nhật hình con dê</a>
                            <a class="dropdown-item" href="#">Bánh sinh nhật hình con khi</a>
                            <a class="dropdown-item" href="#">Bánh sinh nhật hình con gà</a>
                            <a class="dropdown-item" href="#">Bánh sinh nhật hình con chó</a>
                            <a class="dropdown-item" href="#">Bánh sinh nhật hình con lợn</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" 
                           aria-haspopup="true" aria-expanded="false">Thông tin </a>
                        <div class="dropdown-menu" aria-labelledby="dropdownId">
                            <a class="dropdown-item" href="#">Lưu ý đặt bánh </a>
                            <a class="dropdown-item" href="#">Mẫu bánh đẹp</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" 
                           aria-haspopup="true" aria-expanded="false">Liên hệ</a>
                        <div class="dropdown-menu" aria-labelledby="dropdownId">
                            <a class="dropdown-item" href="#">Hướng dẫn đặt bánh</a>
                           
                        </div>
                    </li>
                 </ul>
                 <form class="form-inline my-2 my-lg-0">
                     <input class="form-control mr-sm-2 circle" type="text" placeholder="Tìm Bánh Nhanh...." >
                     <button class="btn btn-outline-success my-2 my-sm-0 circle" type="submit">Search</button>
                 </form>
             </div>
            </div>
         </nav>
      </header>
      <div class="body container">
          <div class="container">
              <div style="height:60px;" class="navLink d-flex justify-content-between">
                  <div class="left">
                      <p class="title"> TRANG CHỦ / <b th:text="${productType.productTypeName}"></b> </p><br><br><br>
                    </div>
                  <div class="right">
                    <span>Showing 1–24 of 45 results</span>
                    
                        <button  id="my-dropdown" class=" dropdown-toggle drops" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Thứ tự mặc định</button>
                        <div class="dropdown-menu" aria-labelledby="my-dropdown">
                            <a class="dropdown-item active" href="#">Thứ tự mặc định</a>
                            <a class="dropdown-item active" href="#">Thứ tự theo mức độ phổ biếnt</a>
                            <a class="dropdown-item active" href="#">Mới Nhất</a>
                            <a class="dropdown-item active" href="#">Thứ tự theo giá: Từ thấp đến cao</a>
                            <a class="dropdown-item active" href="#">Thứ tự theo giá: Từ cao đến thấp</a>
                        </div>
               </div>
              </div>
              <div class="text">
                <p>Bánh sinh nhật trang trí hình socola, chữ nổi trang nhã, có thể dùng tặng nhiều đối tượng khác nhau.</p>
                <p>Bánh có thể giao nhanh trong vòng 1 – 2h sau khi chốt đơn (không áp dụng giờ cao điểm, các địa điểm giao ngoại thành HN…)</p>
            </div>
              <div class="product row">
                  <div class="item" th:each="product :${productList}">
                      <a th:href="@{/product(productId=${product.productId})}" class="product2">
                      <img th:src="@{${'/img/' + product.productImage}}" alt="" class="product1"></a>
                      <div class="infomation">
                        <p class="name"><a href="" class="name" th:text="${product.productName}">...</a></p>
                        <p class="price"> <b th:text="${product.price}"> 270,000</b> đ </p>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      <div style="text-align: center; color: grey;" class="line">
        <p>_______________________________________________________________________________________</p>
      </div>
      <footer style="background-color: rgb(231, 225, 225); "> 
        <div style="display: inline;" class="footer">
            <ul>
                <li style="margin-left: 200px;" class="chinhsach"><a class="textcolor" href="https://giaobanhnhanh.com/chinh-sach-doi-tra-hang/">CHÍNH SÁCH ĐỔI TRẢ HÀNG</a></li>
                <li class="chinhsach"  ><a class="textcolor" href="https://giaobanhnhanh.com/chinh-sach-van-chuyen/">CHÍNH SÁCH VẬN CHUYỂN</a></li>
                <li class="chinhsach"  ><a class="textcolor" href="https://giaobanhnhanh.com/chinh-sach-thanh-toan/">CHÍNH SÁCH THANHH TOÁN</a></li>
                <li class="chinhsach" ><a class="textcolor" href="https://giaobanhnhanh.com/thoa-thuan-nguoi-dung/">THỎA THUẬN NGƯỜI DÙNG</a></li>
                <li class="chinhsach" ><a class="textcolor" href="https://giaobanhnhanh.com/chinh-sach-quyen-rieng-tu/">CHÍNH SÁCH QUYỀN RIÊNG TƯ</a></li>
            </ul>
        </div>
        <div style="text-align: center; " class="footers">
            <img class="logo"src="img/logo-giao-banh-nhanh.png" alt="">
            <p>
                Địa chỉ : Cs 1: Mỹ Đình, Từ Liêm, Hà Nội <br>
                Cs 2: Phương Canh, Từ Liêm, Hà Nội <br>
                Hotline : 0966 291 687 <br>
                Email : info@giaobanhnhanh.com <br>
            </p>
        </div>
  </footer>
     
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>