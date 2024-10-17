<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
          <meta charset="utf-8" />
          <meta http-equiv="X-UA-Compatible" content="IE=edge" />
          <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
          <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
          <meta name="author" content="Hỏi Dân IT" />
          <title>Product Details - Hỏi Dân IT</title>
          <link href="/css/styles.css" rel="stylesheet" />
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" />
          <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        </head>

        <body class="sb-nav-fixed">
          <jsp:include page="../layout/header.jsp" />
          <div id="layoutSidenav">
            <jsp:include page="../layout/sidebar.jsp" />
            <div id="layoutSidenav_content">
              <main>
                <div class="container-fluid px-4">
                  <h1 class="mt-4">Product Management</h1>
                  <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item">
                      <a href="/admin">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item active">Product Details</li>
                  </ol>
                  <div class="container mt-5">
                    <div class="row justify-content-center">
                      <div class="col-md-8">
                        <div class="card shadow-lg">
                          <div class="card-header bg-primary text-white">
                            <h5 class="mb-0">Product Information (ID: ${product.id})</h5>
                          </div>
                          <div class="card-body">
                            <div class="text-center mb-4">
                              <img class="img-fluid" src="/images/product/${product.image}" alt="${product.name}"
                                style="max-width: 300px;" />
                            </div>
                            <ul class="list-group list-group-flush">
                              <li class="list-group-item">
                                <strong>ID:</strong> ${product.id}
                              </li>
                              <li class="list-group-item">
                                <strong>Name:</strong> ${product.name}
                              </li>
                              <li class="list-group-item">
                                <strong>Quantity:</strong> ${product.quantity}
                              </li>
                              <li class="list-group-item">
                                <strong>Short Description:</strong> ${product.shortDesc}
                              </li>
                              <li class="list-group-item">
                                <strong>Sold:</strong> ${product.sold}
                              </li>
                              <li class="list-group-item">
                                <strong>Target:</strong> ${product.target}
                              </li>
                              <li class="list-group-item">
                                <strong>Factory:</strong> ${product.factory}
                              </li>
                              <li class="list-group-item">
                                <strong>Detail_Desc:</strong> ${product.detailDesc}
                              </li>
                              <li class="list-group-item">
                                <strong>Price:</strong>
                                <fmt:formatNumber type="number" value="${product.price}" /> đ
                              </li>
                            </ul>
                          </div>
                        </div>
                        <div class="mt-3 text-center mb-5">
                          <a href="/admin/product?page=${page}" class="btn btn-success">
                            <i class="fas fa-arrow-left"></i> Back to Product List
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </main>
              <jsp:include page="../layout/footer.jsp" />
            </div>
          </div>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
          <script src="/js/scripts.js"></script>
        </body>

        </html>