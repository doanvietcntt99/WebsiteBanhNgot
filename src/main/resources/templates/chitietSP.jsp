<!doctype html>
<html lang="en">

<head>
    <title>MB-122 Bánh kem trang trí cherry đỏ</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/chitiet.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href=“https://fonts.googleapis.com/css?family=Hammersmith+One&display=swap” rel=“stylesheet”>

</head>

<body>
    <header class="header">

        <nav class="navbar navbar-expand-sm navbar-light bg-light ">
            <div style="margin: 0px 100px" class="container">
                <a class="navbar-brand" href="#"><img class="logo" src="img/logo-giao-banh-nhanh.png" alt=""> </a>
                <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                    data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                    aria-label="Toggle navigation">
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
                                <a class="dropdown-item" th:each="productType :${prodctTypeListActive}"
                                    th:href="@{/category(categoryId=${productType.productTypeId})}"
                                    th:text="${productType.productTypeName}"></a>
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
                        <input style="font-size: 14px;" class="form-control mr-sm-2 circle" type="text"
                            placeholder="Tìm bánh nhanh...">
                        <button style="font-size: 14px;" class="btn btn-outline-success my-2 my-sm-0 circle"
                            type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </header>

    <div class="body container">
        <div class="header-container">
            <div class="navLink d-flex justify-content-between">
                <div class="left">
                    <p style="font-size: 16px; margin-bottom: 25px;" title>
                        <a style="color: rgb(187, 187, 187);" href="/">TRANG CHỦ</a> / <a
                            style="color: rgb(187, 187, 187);"
                            th:href="@{/category(categoryId=${productType.productTypeId})}"
                            th:text="${productType.productTypeName}"> </a>
                    </p>
                </div>
            </div>
        </div>
        <div class="product-container flex-container ">
            <div style="height: 550px;" class="item">
                <a th:href="@{${'/img/' + product.productImage}}">
                    <img th:src="@{${'/img/' + product.productImage}}" class="anh" alt=""
                        th:alt="@{${product.productImage}}" data-caption=""
                        th:data-src="@{${'/img/' + product.productImage}}"
                        th:data-large_image="@{${'/img/' + product.productImage}}" data-large_image_width="722"
                        data-large_image_height="665" th:srcset="@{${'/img/' + product.productImage}}"
                        sizes="(max-width: 510px) 100vw, 510px">
                </a>
            </div>

            <div class="item item2">
                <div>
                    <h3 style="color: rgb(252, 168, 182);" th:text="${product.productName}">...</h3>
                    <div class="is-divider small"></div>
                    <div class="price-wrapper">
                        <p class="price product-page-price ">
                            <b>
                                <span style="font-size: 20px; color: rgb(253, 218, 165); margin-right: auto;"
                                    class="woocommerce-Price-amount amount" th:text="${product.price}">...</span><span
                                    class="woocommerce-Price-currencySymbol">₫</span>
                            </b>
                        </p>
                    </div>
                </div>
                <div>
                    <p>
                        <span>
                            <img class="icon" src="https://giaobanhnhanh.com/wp-content/uploads/2018/01/icon-car.png"
                                alt=""> Giao bánh trong vòng 2h kể từ khi đặt
                        </span>
                    </p>
                    <p>
                        <span class="linee">
                            <img class="icon" src="https://giaobanhnhanh.com/wp-content/uploads/2020/05/delivery.png"
                                alt="">
                            FREESHIP Cầu Giấy, Mỹ Đình, đồng giá ship nội thành 10k
                        </span>
                    </p>
                    <p>
                        <span class="linee">
                            <img class="icon"
                                src="https://giaobanhnhanh.com/wp-content/uploads/2020/01/icon-banh-sinh-nhat.png"
                                alt="">
                            FREE bộ phụ kiện gồm nến phụt, mũ, nến thổi, dao đĩa...
                        </span>
                    </p>
                    <p>
                        <span class="linee">
                            <img style="width: 30px; height: 30px;" class="icon"
                                src="https://giaobanhnhanh.com/wp-content/uploads/2018/01/cake-standard.png" alt="">
                            Gần 1000 mẫu bánh đa dạng
                        </span>
                    </p>
                    <p>
                        <span class="linee">
                            <img style="width: 30px; height: 30px;" class="icon"
                                src="https://giaobanhnhanh.com/wp-content/uploads/2019/11/gift-icon.jpg" alt="">
                            Thanh toán đa dạng, hỗ trợ tặng bánh cho người thân tại HN
                        </span>
                    </p>
                </div>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#modelId"
                    style="  border-style: outset; color: #ffffff; background-color: #971521; size: 17px; text-align: center;margin: 5px 5px; text-decoration: none; width: 100%;">
                    Đặt bánh ngay
                </button>
                <div style="padding: 5px;" class="product-meta">
                    <p class="bd">
                        Danh mục: <a href="https://giaobanhnhanh.com/danh-muc-sp/banh-kem-trang-tri-dep/">Bánh sinh nhật
                            trang trí đẹp</a>,
                        <a href="https://giaobanhnhanh.com/danh-muc-sp/tang-nguoi-than/">Tặng người thân</a>
                    </p>

                    <p style="margin-top: -20px;" class="bd">
                        Từ khóa: <a href="https://giaobanhnhanh.com/tu-khoa/banh-kem-cherry/"> bánh kem cherry</a> ,
                        <a href="https://giaobanhnhanh.com/tu-khoa/banh-sinh-nhat-dep/">bánh kem đẹp</a> ,
                        <a href="https://giaobanhnhanh.com/tu-khoa/banh-sinh-nhat-dep/">bánh sinh nhật đẹp</a>
                    </p>
                </div>
            </div>
            <!-- Modal -->
            <div style="font-size: 13px;" class="modal fade" id="modelId" tabindex="-1" role="dialog"
                aria-labelledby="modelTitleId" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content than1">
                        <div class="modal-header">

                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body than">
                            <h5 class="modal-title" style="text-align: center; justify-content: center;">
                                <img style="text-align: center;justify-content: center;" width="222" height="60"
                                    src="img/logo-giao-banh-nhanh.png" alt="">
                            </h5>
                            <div class="container-fluid">
                                <p style="text-align: left;">Đặt bánh:</p>
                                <b th:text="${product.productName}">...</b><br>
                                <!--<div class=“button”>-->
                                <!--<button><span>Subscribe</span></button>-->
                                <!--</div>-->
                                <div class=“popup”>
                                    <div class=“content”>
                                        <div class=“container”>
                                            <div class=“circles”>
                                                <div class=“circle”></div>
                                                <div class=“circle”></div>
                                                <div class=“circle”></div>
                                                </di>

                                                <!-- <img src=“https://webdevtrick.com/wp-content/uploads/logo-fb-1.png” alt=“Car”>-->



                                                <form style="margin-top: 5px;"
                                                    th:action="@{/createOrder(productId=${product.productId})}"
                                                    th:object="${order}" method="POST">
                                                    <div class="row">

                                                        <div class="col-sm-6">
                                                            <label for="">Họ tên: </label><br>
                                                            <input class="form-control" type="text"
                                                                th:field="*{fullNameGuest}"><br>
                                                            <label for="">Địa chỉ nhận bánh:</label><br>
                                                            <input class="form-control" type="text"
                                                                th:field="*{addressGuest}" name="" id=""><br>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label for="">Số điện thoại:</label><br>
                                                            <input class="form-control" type="text"
                                                                th:field="*{phoneGuest}" name="" id=""><br>
                                                            <label for="">Số lượng:</label><br>
                                                            <input  class="form-control" type="number"
                                                                th:field="*{sumOfProduct}" name="" id=""><br>
                                                                <label for="">Email:</label><br>
                                                                <input  class="form-control" type="email"
                                                                                                                                th:field="*{emailGuest}" name="" id=""><br>
                                                        </div>


                                                    </div>

                                                    <label for=""> Nội dung ghi trên bánh: </label> <br>
                                                    <textarea class="form-control" name="" id="" cols="81" rows="5"
                                                        th:field="*{orderContext}">
                                                        </textarea>
                                                        <br>
                                                    <input type="text" class="form-control fade" th:field="*{productId}" th:value="${order.productId}" disabled></input>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                    <button type="submit" class="btn btn-primary pull-right">Tạo Mới</button>
                                                    <input class="btn btn-primary pull-right" type="reset" value="Nhập lại">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                <script
                                    src=‘https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js’></script>
                                <script src=“function.js”></script>
                            </div>
                        </div>


                    </div>
                </div>
            </div>

            <script>
                $('#exampleModal').on('show.bs.modal', event => {
                    var button = $(event.relatedTarget);
                    var modal = $(this);
                    // Use above variables to manipulate the DOM

                });
            </script>



        </div>
    </div>
    </div>


    <div class="content3 container">
        <hr width="100%">
        <div class="mota">
            <ul class="tabs wc-tabs product-tabs small-nav-collapse nav nav-uppercase nav-line nav-center"
                role="tablist">
                <li class="description_tab active" id="tab-title-description" role="tab"
                    aria-controls="tab-description">

                </li>
            </ul>

            <p th:text="${product.detail}">
                Bánh kem trang trí cherry đỏ là một mẫu bánh phù hợp với rất nhiều đối tượng, nhờ cách trang trí cực kì
                nhã nhặn mà vẫn nổi bật. Bánh có thể làm và giao sau 2h kể từ khi bạn đặt bánh sinh nhật tại Giao Bánh
                Nhanh.
            </p>

            <hr width="100%" />
            <p style="text-align: center; margin-top: -15px;"> <a
                    style="border-top:3px solid rgb(156, 16, 16);    font-weight: 700; font-family: font-family: 'Roboto', sans-serif;">MÔ
                    TẢ</a>
            </p>
            <br><br>

            <img class="imgmota" src="https://giaobanhnhanh.com/wp-content/uploads/2019/07/bang-gia-banh-03-2020.jpg"
                alt=""><br><br>
            <p>*** Để đảm bảo bánh 100% tươi ngon, các thợ bánh của Giao Bánh Nhanh sẽ chỉ bắt đầu làm bánh sau khi nhận
                được order và giao bánh ngay khi làm xong. Quý khách sẽ nhận được bánh sau từ 1 – 2h đặt bánh.</p>
            <p>Khách hàng tại Giao Bánh Nhanh đồng ý với <a style="text-decoration: none" href="#">Thỏa thuận người
                    dùng</a> và các quy định khác của chúng tôi</p><br><br><br>
        </div>
        <hr width="100%" />
        <p style="text-align: center; margin-top: -15px;">
        </p>
        <br>

        <h3 style="color: hotpink;" class="text-center">SẢN PHẨM TƯƠNG TỰ</h3>
        <div class="product row ">
            <div class="item hello">
                <a href="" class="product2"><img
                        src="https://giaobanhnhanh.com/wp-content/uploads/2020/11/banh-troll-banh-kem-troll-ban-nam-gai-dep-tien-vang-dollar-co-du-247x296.jpg"
                        alt="" class="product1"></a>
                <div style="background-color: #f8f9fa;" class="infomation">
                    <p class="name"><a href="" class="name">MS-531 Bánh troll - Bánh kem người đẹp và đại gia</a></p>
                    <p class="price"> <b> 390,000đ</b> </p>
                </div>
            </div>
            <div class="item">
                <a href="" class="product2"><img
                        src="https://giaobanhnhanh.com/wp-content/uploads/2020/11/banh-kem-hinh-ngua-1-sung-dang-yeu-247x296.jpg"
                        alt="" class="product1"></a>
                <div class="infomation">
                    <p class="name"><a href="" class="name">MS-644 Bánh kem unicorn</a></p>
                    <p class="price"> <b> 490,000đ</b> </p>
                </div>
            </div>
            <div class="item">
                <a href="" class="product2"><img
                        src="https://giaobanhnhanh.com/wp-content/uploads/2018/07/banh-sinh-nhat-trang-tri-siro-nho-1-1-247x296.jpg"
                        alt="" class="product1"></a>
                <div class="infomation">
                    <p class="name"><a href="" class="name">MS-235 Bánh gato siro nho</a></p>
                    <p class="price"> <b> 290,000đ</b> </p>
                </div>
            </div>
            <div class="item">
                <a href="" class="product2"><img
                        src="https://giaobanhnhanh.com/wp-content/uploads/2020/11/banh-gato-kem-chanh-leo-cho-ban-be-247x296.jpg"
                        alt="" class="product1"></a>
                <div class="infomation">
                    <p class="name"><a href="" class="name">MS-735 Bánh gato chanh leo cho bạn bè</a></p>
                    <p class="price"> <b> 270,000đ</b> </p>
                </div>
            </div>

        </div>
    </div>
    <hr width="100%" />

    <footer style="background-color: rgb(231, 225, 225); ">
        <div style="display: inline;" class="footer">
            <ul>
                <li class="chinhsach"><a class="textcolor" href="#">CHÍNH SÁCH ĐỔI TRẢ HÀNG</a></li>
                <li class="chinhsach"><a class="textcolor" href="#">CHÍNH SÁCH VẬN CHUYỂN</a></li>
                <li class="chinhsach"><a class="textcolor" href="#">CHÍNH SÁCH THANHH TOÁN</a></li>
                <li class="chinhsach"><a class="textcolor" href="#">THỎA THUẬN NGƯỜI DÙNG</a></li>
                <li class="chinhsach" s><a class="textcolor" href="#">CHÍNH SÁCH QUYỀN RIÊNG TƯ</a></li>
            </ul>
        </div>
        <div style="text-align: center; " class="footers">
            <img class="logo" src="img/logo-giao-banh-nhanh.png" alt="">
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
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>