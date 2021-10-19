<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Hello, world!</title>
    <style>
        th, td {
            text-align: center;
            vertical-align: middle;
        }
        form {
            display: flex;
            justify-content: center;
        }

    </style>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand text-dark" href="#">Admin Page</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="#">고객관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="#">맛집관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="#">리뷰관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="#">차트분석</a>
                    </li>
                </ul>
                <span class="navbar-text">
                    <a class="nav-link text-dark" href="#">로그아웃</a>
                </span>
            </div>
        </div>
    </nav>

    <div class="container mt-5 shadow-lg">
        <form class="row g-3 rounded p-2">
            <div class="col-auto">  
                <select class="form-select col-auto" aria-label="Default select example">
                    <option selected>검색옵션</option>
                    <option value="1">맛집이름</option>
                    <option value="2">주소</option>
                    <option value="2">카테고리</option>
                </select>
            </div>
            <div class="col-auto">
                <label for="inputPassword2" class="visually-hidden">Password</label>
                <input type="password" class="form-control" id="inputPassword2" placeholder="Password">
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">검색</button>
            </div>
        </form>
    </div>

    <div class="container bg-light pt-4 pb-3 px-5 mt-4 rounded shadow-lg">
        <h2>맛집 목록</h2>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">맛집이름</th>
                    <th scope="col">전화번호</th>
                    <th scope="col">카테고리</th>
                    <th scope="col">상세카테고리</th>
                    <th scope="col">주소</th>
                    <th scope="col">등록일</th>
                    <th scope="col">조회수</th>
                    <th scope="col">삭제</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>602디저트</td>
                    <td>02-419-1511</td>
                    <td>일식</td>
                    <td>돈까스</td>                    
                    <td>서울 강남구 일원동 677-11</td>
                    <td>2021-10-15</td>
                    <td>5</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm">삭제</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>요리하는남자</td>
                    <td>02-419-1511</td>
                    <td>한식</td>
                    <td>냉면</td>
                    <td>서울 송파구 잠실동 180-9</td>
                    <td>2021-10-12</td>
                    <td>3</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm">삭제</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>602디저트</td>
                    <td></td>
                    <td>일식</td>
                    <td>돈까스</td>
                    <td>서울 강남구 일원동 677-11</td>
                    <td>2021-10-15</td>
                    <td>5</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm">삭제</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>요리하는남자</td>
                    <td>02-419-1511</td>
                    <td>한식</td>
                    <td>냉면</td>
                    <td>서울 송파구 잠실동 180-9</td>
                    <td>2021-10-12</td>
                    <td>3</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm">삭제</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row">5</th>
                    <td>602디저트</td>
                    <td></td>
                    <td>한식</td>
                    <td>냉면</td>
                    <td>서울 강남구 일원동 677-11</td>
                    <td>2021-10-15</td>
                    <td>5</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm">삭제</button>
                    </td>
                </tr>

            </tbody>
        </table>
    </div>
    <nav aria-label="Page navigation example" class="mt-4">
        <ul class="pagination" style="justify-content: center;">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </nav>
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>

</html>