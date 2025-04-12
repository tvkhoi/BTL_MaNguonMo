Quản  lí thư viện
Giới thiệu
Hệ thống quản lý thư viện được thiết kế để xem các cuốn sách có sẵn trong thư viện. Nó cho phép người dùng mượn/trả sách từ thư viện. Phần phụ trợ được thiết kế như một Kiến trúc nguyên khối với nhiều sắc thái khác nhau như được thảo luận bên dưới.
Công nghệ và sự phụ thuộc được sử dụng
https://gradle.org/ được sử dụng như một công cụ quản lý sự phụ thuộc
Spring Boot được sử dụng để xây dựng các ứng dụng web đơn giản và viết REST API.
Spring Security được sử dụng để Xác thực và Ủy quyền.
Spring data JPA (Hibernate) Được sử dụng để giảm thời gian viết các truy vấn sql được mã hóa cứng và thay vào đó cho phép viết mã dễ đọc và có khả năng mở rộng hơn nhiều
MySQL được sử dụng như một kho lưu trữ bền vững của Java
Dự án Lombok Giảm thời gian viết mã chuẩn Java.
Thiết kế Backend
Các thực thể
Các thực thể được lấy tên từ các thực thể trong thế giới thực có thể sử dụng các ứng dụng

1.Sách có các thuộc tính:
iMaSach (khóa chính duy nhất), tiêu đề, tác giả, NXB, năm xuất bản, số lượng, thể loại.
2.Độc giả có các thuộc tính:
iMaDocGia (khóa chính duy nhất), tên độc giả, địa chỉ, số điện thoại, địa chỉ email.
3.Phiếu Mượn có thuộc tính:
iMaPhieuMuon (khóa chính duy nhất), iMaDocGia (khóa ngoại), ngày mượn, ngày trả, trạng thái {Đã trả, Đăng mượn}.
4.Chi tiết phiếu mượn có các thuộc tính:
iMaChiTietPhieuMuon (khóa chính duy nhất), iMaPhieuMuon (khóa ngoại), iMaSach (khóa ngoại), Số lượng.
