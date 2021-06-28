<!doctype html>
<html lang="en">
  <head>
    <title>GIỚI THIỆU</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/gioithieu.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  <body>
    <header class="header">
         
        <nav class="navbar navbar-expand-sm navbar-light bg-light ">
            <div style="margin: 0px 100px" class="container">
            <a class="navbar-brand" href="#"><img class= "logo" src="img/logo-giao-banh-nhanh.png" alt=""> </a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavId">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Trang chủ <span class="sr-only">(current)</span></a>
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
                              <a class="dropdown-item" href="#">Bánh sinh nhật hình con rồng</a>
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
                    <input style="font-size: 14px;" class="form-control mr-sm-2 circle" type="text" placeholder="Tìm bánh nhanh..." >
                    <button style="font-size: 14px;" class="btn btn-outline-success my-2 my-sm-0 circle" type="submit">Search</button>
                </form>
            </div>
           </div>
        </nav>
     </header>
      <div class="text">
        <h2>
            <strong>Câu chuyện của chúng tôi</strong>
        </h2>
      </div>
      <div class="anh">
          <img src="https://giaobanhnhanh.com/wp-content/uploads/2015/08/cover-fb.png" alt="">
      </div>
      <div id="content">
          <div class="content">
              <h3>
                <strong>“Bánh sinh nhật phải ngon. Và an toàn”.</strong>
              </h3>
              <p>Giao Bánh Nhanh khởi đầu là thương hiệu đặt và giao bánh sinh nhật online Hà Nội với tiêu chí:</p>
              <ul>
                  <li>Bánh giao tận nơi, thuận tiện cho khách</li>
                  <li>Bánh chỉ được làm theo đơn đặt hàng của khách để đảm bảo độ tươi ngon</li>
                  <li>Cam kết 100% không sử dụng chất bảo quản, an toàn với sức khỏe của khách hàng</li>
              </ul>
              <p>Sau 4 năm thành lập và phát triển, Giao Bánh Nhanh ngày càng nhận được sự ủng hộ của&nbsp; đông đảo khách hàng, tiếp tục nghiên cứu nhiều dòng sản phẩm bánh sinh nhật theo yêu cầu phức tạp như: Bánh sinh nhật 3D, bánh sinh nhật công ty, bánh sinh nhật nhiều tầng, bánh sinh nhật hoa tươi…Bánh sinh nhật kem tươi rất khó tạo hình, tuy nhiên các thợ bánh Giao Bánh Nhanh nỗ lực nghiên cứu và nâng cao tay nghề để đáp ứng nhu cầu của khách hàng. Đảm bảo các mẫu bánh sinh nhật tươi ngon, cốt bánh gateaux chiffon mềm xốp, tan trong miệng mà vẫn giữ được tính thẩm mỹ tinh xảo của bánh.&nbsp;</p>
          </div>
          <div class="content">
              <h3>
                  <strong>Về chúng tôi</strong>
              </h3>
              <div class="wpb_wrapper">Giao Bánh Nhanh ra đời nhằm mang đến sự tiện dụng tối ưu cho khách hàng. Trong cuộc sống bận rộn hiện đại, bạn không cần thiết phải chạy ra xưởng bánh để tìm và chọn mẫu cho&nbsp;<a href="https://giaobanhnhanh.com/danh-muc-sp/album-banh-dep/">bánh sinh nhật đẹp</a>&nbsp;cho những người thân yêu nữa. Chỉ cần liên hệ Giao Bánh Nhanh, chọn mẫu bánh hoặc đưa ra yêu cầu vẽ hình, và nhân viên của chúng tôi sẽ ngay lập tức làm bánh, trang trí và giao bánh đúng hạn.Không như các mẫu bánh có sẵn ở cửa hàng, thợ bánh phải cho thêm chất bảo quản và vị ngọt để có thể giữ bánh từ 5 – 7 ngày sau khi làm. <strong>Bánh gato, bánh sinh nhật tại Giao Bánh Nhanh chỉ được làm sau khi khách hàng điện thoại đặt bánh. Công thức bánh gateaux chiffon giúp cốt bánh mềm xốp, bánh làm xong giao luôn nên không quá ngọt, không bị khô cứng</strong>Giao Bánh Nhanh cung cấp các mẫu bánh sinh nhật đa dạng cho nhiều đối tượng: bánh sinh nhật in ảnh kỷ niệm những dịp ý nghĩa,&nbsp;<a href="https://giaobanhnhanh.com/danh-muc-sp/hello-kitty/">bánh kem mèo Kitty</a>&nbsp;dễ thương cho bé gái,&nbsp;<a href="https://giaobanhnhanh.com/danh-muc-sp/banh-hinh-o-to/">bánh sinh nhật hình&nbsp;oto</a>&nbsp;ngộ nghĩnh cho bé trai,&nbsp;<a href="https://giaobanhnhanh.com/danh-muc-sp/banh-cuoi-ky-niem/">bánh cưới&nbsp;</a>nhiều tầng sang trọng… Chỉ cần nhấc điện thoại gọi ngay 0966-291-687, bạn sẽ được tư vấn ngay mẫu bánh phù hợp cho người thân yêu </div>
    
          </div>
          <div class="content3">
                <h4 style="font-weight: bold;">Liên hệ</h4>
                <p>
                    Hotline Đặt bánh ngay : 0966 291 687 <br>
                    Email : info@giaobanhnhanh.com <br>
                    Địa chỉ: <br>
                    Cs 1: Mỹ Đình, Từ Liêm, Hà Nội <br>
                    Cs 2: Phương Canh, Từ Liêm, Hà Nội <br>
                    
                    
                </p>

          </div>
          <footer style="background-color: rgb(231, 225, 225); "> 
            <div style="display: inline;" class="footer">
                <ul>
                    <li style="margin-left: 200px;" class="chinhsach"><a class="textcolor" href="#">CHÍNH SÁCH ĐỔI TRẢ HÀNG</a></li>
                    <li class="chinhsach"  ><a class="textcolor" href="#">CHÍNH SÁCH VẬN CHUYỂN</a></li>
                    <li class="chinhsach"  ><a class="textcolor" href="#">CHÍNH SÁCH THANHH TOÁN</a></li>
                    <li class="chinhsach" ><a class="textcolor" href="#">THỎA THUẬN NGƯỜI DÙNG</a></li>
                    <li class="chinhsach" ><a class="textcolor" href="#">CHÍNH SÁCH QUYỀN RIÊNG TƯ</a></li>
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
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      
    
</body>  
      </div>