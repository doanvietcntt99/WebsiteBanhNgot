<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8" />
      <link rel="apple-touch-icon" sizes="76x76" href="http://localhost:8181/img/apple-icon.png">
      <link rel="icon" type="image/png" href="http://localhost:8181/img/favicon.png">
      <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
      <title>
         Material Dashboard by Creative Tim
      </title>
      <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
      <!--     Fonts and icons     -->
      <link rel="stylesheet" type="text/css"
         href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
      <!-- CSS Files -->
      <link href="http://localhost:8181/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
      <!-- CSS Just for demo purpose, don't include it in your project -->
      <link href="http://localhost:8181/demo/demo.css" rel="stylesheet" />
   </head>
   <body class="">
      <div class="wrapper ">
         <div class="sidebar" data-color="purple" data-background-color="white" data-image="http://localhost:8181/img/sidebar-1.jpg">
            <!--
               Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

               Tip 2: you can also add an image using data-image tag
               -->
            <div class="logo"><a href="/" class="simple-text logo-normal">
               GIAO BÁNH NHANH
               </a>
            </div>
            <div class="sidebar-wrapper">
               <ul class="nav">
                  <li class="nav-item">
                     <a class="nav-link" href="/admin/home">
                        <i class="material-icons">dashboard</i>
                        <p>Trang Chủ</p>
                     </a>
                  </li>
                  <li class="nav-item ">
                     <a class="nav-link" href="/userProfile">
                        <i class="material-icons">person</i>
                        <p>Thông Tin Cá Nhân</p>
                     </a>
                  </li>
                  <li class="nav-item active">
                     <a class="nav-link" href="/cakesList">
                        <i class="material-icons">content_paste</i>
                        <p>Danh Sách Sản Phẩm</p>
                     </a>
                  </li>
                  <li class="nav-item ">
                     <a class="nav-link" href="/viewListCategory">
                        <i class="material-icons">library_books</i>
                        <p>Danh Sách Loại Bánh</p>
                     </a>
                  </li>
                  <li class="nav-item ">
                     <a class="nav-link" href="/viewListOrder">
                        <i class="material-icons">bubble_chart</i>
                        <p>Danh Sách Đơn Hàng</p>
                     </a>
                  </li>
                  <li class="nav-item ">
                     <a class="nav-link" href="/viewListGuest">
                        <i class="material-icons">location_ons</i>
                        <p>Danh Sách Người Dùng</p>
                     </a>
                  </li>
                  <li class="nav-item ">
                                                         <a class="nav-link" href="/viewListAdmin">
                                                            <i class="material-icons">location_ons</i>
                                                            <p>Danh Sách Quản Trị Viên</p>
                                                         </a>
                                                      </li>
               </ul>
            </div>
         </div>
         <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
               <div class="container-fluid">
                  <div class="navbar-wrapper">
                     <a class="navbar-brand" href="javascript:;">Quản trị hệ thống</a>
                  </div>
                  <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index"
                     aria-expanded="false" aria-label="Toggle navigation">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="navbar-toggler-icon icon-bar"></span>
                  <span class="navbar-toggler-icon icon-bar"></span>
                  <span class="navbar-toggler-icon icon-bar"></span>
                  </button>
                  <div class="collapse navbar-collapse justify-content-end">
                     <form class="navbar-form">
                        <div class="input-group no-border">
                           <input type="text" value="" class="form-control" placeholder="Tìm kiếm...">
                           <button type="submit" class="btn btn-white btn-round btn-just-icon">
                              <i class="material-icons">search</i>
                              <div class="ripple-container"></div>
                           </button>
                        </div>
                     </form>
                     <ul class="navbar-nav">
                        <li class="nav-item">
                           <a class="nav-link" href="javascript:;">
                              <i class="material-icons">dashboard</i>
                              <p class="d-lg-none d-md-block">
                                 Stats
                              </p>
                           </a>
                        </li>
                        <li class="nav-item dropdown">
                           <a class="nav-link" href="http://example.com" id="navbarDropdownMenuLink"
                              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <i class="material-icons">notifications</i>
                              <span class="notification">5</span>
                              <p class="d-lg-none d-md-block">
                                 Some Actions
                              </p>
                           </a>
                           <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                              <a class="dropdown-item" th:each="notification :${notificationListActive}" th:href="@{/SeenNotification(idNotification=${notification.idNotification})}" th:text="${notification.content}">...</a>
                           </div>
                        </li>
                        <li class="nav-item dropdown">
                           <a class="nav-link" href="javascript:;" id="navbarDropdownProfile"
                              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <i class="material-icons">person</i>
                              <p class="d-lg-none d-md-block">
                                 Account
                              </p>
                           </a>
                           <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                              <a class="dropdown-item" href="/userProfile">Thông tin cá nhân</a>
                                                            <a class="dropdown-item" href="#">Cài đặt</a>
                                                            <div class="dropdown-divider"></div>
                                                            <a class="dropdown-item" href="/logout">Đăng xuất</a>
                           </div>
                        </li>
                     </ul>
                  </div>
               </div>
            </nav>
            <!-- End Navbar -->
            <div class="content">
               <div class="container-fluid">
                  <div class="row">
                     <div class="col-md-12">
                        <div class="card">
                           <div class="card-header card-header-primary">
                              <div style="float:left">
                                 <h4 class="card-title ">Danh sách Sản Phẩm</h4>
                                 <p class="card-category">Để xem chi tiết sản phẩm, vui lòng chọn vào sản phẩm
                                 </p>
                              </div>
                              <div style="float:right"><button type="button" class="btn btn-info btn-lg"
                                 data-toggle="modal" data-target="#ModelAddNewProduct">Thêm mới sản
                                 phẩm</button>
                              </div>
                           </div>
                           <div class="card-body">
                              <div class="table-responsive">
                                 <table class="table table-hover">
                                    <thead class=" text-primary">
                                       <th>
                                          ID
                                       </th>
                                       <th>
                                          Tên Sản Phẩm
                                       </th>
                                       <th>
                                          Loại Sản Phẩm
                                       </th>
                                       <th>
                                          Chi Tiết
                                       </th>
                                       <th>
                                          Giá Thành
                                       </th>
                                       <th>
                                          Hành động
                                       </th>
                                    </thead>
                                    <tbody>
                                       <tr th:each="product :${cakeList.pageList}">
                                          <td th:utext="${product.productId}">...</td>
                                          <td th:utext="${product.productName}">...</td>
                                          <td th:utext="${product.productTypeName}">...</td>
                                          <td th:utext="${product.detail}">...</td>
                                          <td class="text-primary" th:utext="${product.price}">...</td>
                                          <td class="td-actions ">
                                             <a th:href="@{/editProduct(productId=${product.productId})}"
                                                type="button" rel="tooltip" title="Chi Tiết"
                                                class="btn btn-primary btn-link btn-sm">
                                             <i class="material-icons">edit</i>
                                             </a>
                                             <a th:href="@{/deleteProduct(productId=${product.productId})}"
                                                type="button" rel="tooltip" title="Xóa"
                                                class="btn btn-danger btn-link btn-sm">
                                             <i class="material-icons">close</i>
                                             </a>
                                             <a th:switch="${product.visible}"
                                                th:href="@{/switchVisible(productId=${product.productId})}"
                                                title="Ẩn/Hiện sản phẩm" type="button" rel="tooltip"
                                                class="btn btn-primary btn-link btn-sm">
                                             <i th:case="${true}" class="material-icons">visibility</i>
                                             <i th:case="${false}"
                                                class="material-icons">visibility_off</i>
                                             </a>
                                          </td>
                                       </tr>
                                    </tbody>
                                 </table>
                              </div>
                              <ul class="pagination">
                                 <li
                                    th:class="${currentIndex == 1}? 'page-item disabled' : 'page-item'">
                                    <a class="page-link" th:href="@{/viewListCakes}">Trang Đầu</a>
                                 </li>
                                 <li
                                    th:class="${currentIndex == 1}? 'page-item disabled': 'page-item' ">
                                    <a class="page-link" aria-label="Previous"
                                       th:href="@{|${baseUrl}${currentIndex - 1}|}"
                                       title='Go to previous page'><span aria-hidden="true">«</span>
                                    <span class="sr-only">Previous</span></a>
                                 </li>
                                 <li th:each="item : ${#numbers.sequence(beginIndex,endIndex)}"
                                    th:class="${item == currentIndex ? 'page-item active' :'page-item' }">
                                    <a class="page-link" th:href="@{|${baseUrl}${item}|}"> <span
                                       th:text='${item}'>1</span>
                                    </a>
                                 </li>
                                 <li
                                    th:class="${currentIndex == totalPageCount}? 'page-item disabled': 'page-item'">
                                    <a class="page-link" aria-label="Next"
                                       th:href="@{|${baseUrl}${currentIndex + 1}|}" title='Trang tiếp theo'><span
                                       aria-hidden="true">»</span> <span class="sr-only">Trang tiếp theo</span></a>
                                 </li>
                                 <li
                                    th:class="${currentIndex == totalPageCount}? 'page-item disabled':'page-item'">
                                    <a class="page-link" th:href="@{|${baseUrl}${totalPageCount}|}">Trang Cuối</a>
                                 </li>
                              </ul>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <footer class="footer">
               <div class="container-fluid">
                  <nav class="float-left">
                     <ul>
                        <li>
                           <a href="https://www.creative-tim.com">
                           GIAO BÁNH NHANH
                           </a>
                        </li>
                        <li>
                           <a href="https://creative-tim.com/presentation">
                           GIỚI THIỆU
                           </a>
                        </li>
                        <li>
                           <a href="http://blog.creative-tim.com">
                           DANH MỤC
                           </a>
                        </li>
                        <li>
                           <a href="https://www.creative-tim.com/license">
                           GIẤY PHÉP
                           </a>
                        </li>
                     </ul>
                  </nav>
                  <div class="copyright float-right">
                     &copy;
                     <script>
                        document.write(new Date().getFullYear())
                     </script>, được xây dựng <i class="material-icons">favorite</i> bởi
                     <a href="https://www.creative-tim.com" target="_blank">Đinh Doãn Việt</a> for a better web.
                  </div>
               </div>
            </footer>
         </div>
      </div>
      <div class="fixed-plugin">
         <div class="dropdown show-dropdown">
            <a href="#" data-toggle="dropdown">
            <i class="fa fa-cog fa-2x"> </i>
            </a>
            <ul class="dropdown-menu">
               <li class="header-title"> Sidebar Filters</li>
               <li class="adjustments-line">
                  <a href="javascript:void(0)" class="switch-trigger active-color">
                     <div class="badge-colors ml-auto mr-auto">
                        <span class="badge filter badge-purple" data-color="purple"></span>
                        <span class="badge filter badge-azure" data-color="azure"></span>
                        <span class="badge filter badge-green" data-color="green"></span>
                        <span class="badge filter badge-warning" data-color="orange"></span>
                        <span class="badge filter badge-danger" data-color="danger"></span>
                        <span class="badge filter badge-rose active" data-color="rose"></span>
                     </div>
                     <div class="clearfix"></div>
                  </a>
               </li>
               <li class="header-title">Images</li>
               <li class="active">
                  <a class="img-holder switch-trigger" href="javascript:void(0)">
                  <img src="http://localhost:8181/img/sidebar-1.jpg" alt="">
                  </a>
               </li>
               <li>
                  <a class="img-holder switch-trigger" href="javascript:void(0)">
                  <img src="http://localhost:8181/img/sidebar-2.jpg" alt="">
                  </a>
               </li>
               <li>
                  <a class="img-holder switch-trigger" href="javascript:void(0)">
                  <img src="http://localhost:8181/img/sidebar-3.jpg" alt="">
                  </a>
               </li>
               <li>
                  <a class="img-holder switch-trigger" href="javascript:void(0)">
                  <img src="http://localhost:8181/img/sidebar-4.jpg" alt="">
                  </a>
               </li>
            </ul>
         </div>
      </div>
      <div class="modal fade" id="ModelAddNewProduct" role="dialog">
         <div class="modal-dialog modal-lg">
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">Modal Header</h4>
               </div>
               <div class="modal-body">
                  <form th:action="@{/addNewProduct}" th:object="${newProduct}" method="POST"
                     >
                     <div class="row">
                        <div class="col-md-6">
                           <div class="form-group">
                              <label class="bmd-label-floating">Tên Bánh</label>
                              <input type="text" class="form-control" th:field="*{productName}">
                           </div>
                        </div>
                        <div class="col-md-6">
                           <div class="form-group">
                              <label class="bmd-label-floating">Loại Bánh</label>
                              <select th:field="*{productTypeId}" name="productTypeId" id="productTypeId">
                                 <option th:each="productType : ${productTypeList}"
                                    th:value="${productType.productTypeId}"
                                    th:text="${productType.productTypeName}"></option>
                              </select>
                           </div>
                        </div>
                        <div class="col-md-12">
                           <div class="form-group">
                              <label class="bmd-label-floating">Mô tả bánh</label>
                              <input type="text" class="form-control" th:field="*{detail}">
                           </div>
                        </div>
                        <div class="col-md-4">
                           <div class="form-group">
                              <label class="bmd-label-floating">Giá bánh</label>
                              <input type="text" class="form-control" th:field="*{price}">
                           </div>
                        </div>
                     </div>
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
      <!--   Core JS Files   -->
      <script src="http://localhost:8181/js/core/jquery.min.js"></script>
      <script src="http://localhost:8181/js/core/popper.min.js"></script>
      <script src="http://localhost:8181/js/core/bootstrap-material-design.min.js"></script>
      <script src="jhttp://localhost:8181/s/plugins/perfect-scrollbar.jquery.min.js"></script>
      <!-- Plugin for the momentJs  -->
      <script src="http://localhost:8181/js/plugins/moment.min.js"></script>
      <!--  Plugin for Sweet Alert -->
      <script src="http://localhost:8181/js/plugins/sweetalert2.js"></script>
      <!-- Forms Validations Plugin -->
      <script src="http://localhost:8181/js/plugins/jquery.validate.min.js"></script>
      <!-- Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
      <script src="http://localhost:8181/js/plugins/jquery.bootstrap-wizard.js"></script>
      <!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
      <script src="http://localhost:8181/js/plugins/bootstrap-selectpicker.js"></script>
      <!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
      <script src="http://localhost:8181/js/plugins/bootstrap-datetimepicker.min.js"></script>
      <!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
      <script src="http://localhost:8181/js/plugins/jquery.dataTables.min.js"></script>
      <!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
      <script src="http://localhost:8181/js/plugins/bootstrap-tagsinput.js"></script>
      <!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
      <script src="http://localhost:8181/js/plugins/jasny-bootstrap.min.js"></script>
      <!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
      <script src="http://localhost:8181/js/plugins/fullcalendar.min.js"></script>
      <!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
      <script src="http://localhost:8181/js/plugins/jquery-jvectormap.js"></script>
      <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
      <script src="http://localhost:8181/js/plugins/nouislider.min.js"></script>
      <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
      <!-- Library for adding dinamically elements -->
      <script src="http://localhost:8181/js/plugins/arrive.min.js"></script>
      <!--  Google Maps Plugin    -->
      <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
      <!-- Chartist JS -->
      <script src="http://localhost:8181/js/plugins/chartist.min.js"></script>
      <!--  Notifications Plugin    -->
      <script src="http://localhost:8181/js/plugins/bootstrap-notify.js"></script>
      <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
      <script src="http://localhost:8181/js/material-dashboard.js?v=2.1.2" type="text/javascript"></script>
      <!-- Material Dashboard DEMO methods, don't include it in your project! -->
      <script src="http://localhost:8181/demo/demo.js"></script>
      <script>
         $(document).ready(function () {
             $().ready(function () {
                 $sidebar = $('.sidebar');

                 $sidebar_img_container = $sidebar.find('.sidebar-background');

                 $full_page = $('.full-page');

                 $sidebar_responsive = $('body > .navbar-collapse');

                 window_width = $(window).width();

                 fixed_plugin_open = $('.sidebar .sidebar-wrapper .nav li.active a p').html();

                 if (window_width > 767 && fixed_plugin_open == 'Dashboard') {
                     if ($('.fixed-plugin .dropdown').hasClass('show-dropdown')) {
                         $('.fixed-plugin .dropdown').addClass('open');
                     }

                 }

                 $('.fixed-plugin a').click(function (event) {
                     // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
                     if ($(this).hasClass('switch-trigger')) {
                         if (event.stopPropagation) {
                             event.stopPropagation();
                         } else if (window.event) {
                             window.event.cancelBubble = true;
                         }
                     }
                 });

                 $('.fixed-plugin .active-color span').click(function () {
                     $full_page_background = $('.full-page-background');

                     $(this).siblings().removeClass('active');
                     $(this).addClass('active');

                     var new_color = $(this).data('color');

                     if ($sidebar.length != 0) {
                         $sidebar.attr('data-color', new_color);
                     }

                     if ($full_page.length != 0) {
                         $full_page.attr('filter-color', new_color);
                     }

                     if ($sidebar_responsive.length != 0) {
                         $sidebar_responsive.attr('data-color', new_color);
                     }
                 });

                 $('.fixed-plugin .background-color .badge').click(function () {
                     $(this).siblings().removeClass('active');
                     $(this).addClass('active');

                     var new_color = $(this).data('background-color');

                     if ($sidebar.length != 0) {
                         $sidebar.attr('data-background-color', new_color);
                     }
                 });

                 $('.fixed-plugin .img-holder').click(function () {
                     $full_page_background = $('.full-page-background');

                     $(this).parent('li').siblings().removeClass('active');
                     $(this).parent('li').addClass('active');


                     var new_image = $(this).find("img").attr('src');

                     if ($sidebar_img_container.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
                         $sidebar_img_container.fadeOut('fast', function () {
                             $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
                             $sidebar_img_container.fadeIn('fast');
                         });
                     }

                     if ($full_page_background.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
                         var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

                         $full_page_background.fadeOut('fast', function () {
                             $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
                             $full_page_background.fadeIn('fast');
                         });
                     }

                     if ($('.switch-sidebar-image input:checked').length == 0) {
                         var new_image = $('.fixed-plugin li.active .img-holder').find("img").attr('src');
                         var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

                         $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
                         $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
                     }

                     if ($sidebar_responsive.length != 0) {
                         $sidebar_responsive.css('background-image', 'url("' + new_image + '")');
                     }
                 });

                 $('.switch-sidebar-image input').change(function () {
                     $full_page_background = $('.full-page-background');

                     $input = $(this);

                     if ($input.is(':checked')) {
                         if ($sidebar_img_container.length != 0) {
                             $sidebar_img_container.fadeIn('fast');
                             $sidebar.attr('data-image', '#');
                         }

                         if ($full_page_background.length != 0) {
                             $full_page_background.fadeIn('fast');
                             $full_page.attr('data-image', '#');
                         }

                         background_image = true;
                     } else {
                         if ($sidebar_img_container.length != 0) {
                             $sidebar.removeAttr('data-image');
                             $sidebar_img_container.fadeOut('fast');
                         }

                         if ($full_page_background.length != 0) {
                             $full_page.removeAttr('data-image', '#');
                             $full_page_background.fadeOut('fast');
                         }

                         background_image = false;
                     }
                 });

                 $('.switch-sidebar-mini input').change(function () {
                     $body = $('body');

                     $input = $(this);

                     if (md.misc.sidebar_mini_active == true) {
                         $('body').removeClass('sidebar-mini');
                         md.misc.sidebar_mini_active = false;

                         $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar();

                     } else {

                         $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar('destroy');

                         setTimeout(function () {
                             $('body').addClass('sidebar-mini');

                             md.misc.sidebar_mini_active = true;
                         }, 300);
                     }

                     // we simulate the window Resize so the charts will get updated in realtime.
                     var simulateWindowResize = setInterval(function () {
                         window.dispatchEvent(new Event('resize'));
                     }, 180);

                     // we stop the simulation of Window Resize after the animations are completed
                     setTimeout(function () {
                         clearInterval(simulateWindowResize);
                     }, 1000);

                 });
             });
         });
      </script>
   </body>
</html>