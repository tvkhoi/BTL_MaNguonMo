INSERT INTO sach (nam_xuat_ban, nha_xuat_ban, so_luong, tac_gia, the_loai, tieu_de)
VALUES ('2020-01-01', 'NXB Kim Đồng', 5, 'Nguyễn Nhật Ánh', 'Thiếu nhi', 'Cho tôi xin một vé đi tuổi thơ'),
       ('2019-06-15', 'NXB Trẻ', 3, 'J.K. Rowling', 'Fantasy', 'Harry Potter và Hòn đá phù thủy'),
       ('2018-03-20', 'NXB Văn Học', 2, 'George Orwell', 'Chính trị', '1984'),
       ('2021-11-10', 'NXB Lao Động', 6, 'Dale Carnegie', 'Kỹ năng sống', 'Đắc nhân tâm'),
       ('2022-09-05', 'NXB Giáo Dục', 4, 'Yuval Noah Harari', 'Lịch sử', 'Sapiens: Lược sử loài người');
INSERT INTO doc_gia (email, dia_chi, ngay_tao, sdt, ten_doc_gia)
VALUES ('an.nguyen@example.com', 'Hà Nội', NOW(), '0912345678', 'Nguyễn Văn An'),
       ('binh.tran@example.com', 'TP.HCM', NOW(), '0987654321', 'Trần Thị Bình'),
       ('cuong.le@example.com', 'Đà Nẵng', NOW(), '0901234567', 'Lê Văn Cường'),
       ('dung.ho@example.com', 'Cần Thơ', NOW(), '0932123456', 'Hồ Thị Dung'),
       ('em.phan@example.com', 'Huế', NOW(), '0945678901', 'Phan Văn Em');
INSERT INTO phieu_muon (ngay_muon, ngay_tra, trang_thai, ma_doc_gia) VALUES
                                                                         (NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'DANG_MUON', 1),
                                                                         (NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 'DANG_MUON', 2),
                                                                         (DATE_SUB(NOW(), INTERVAL 10 DAY), DATE_SUB(NOW(), INTERVAL 3 DAY), 'DA_TRA', 3),
                                                                         (NOW(), DATE_ADD(NOW(), INTERVAL 10 DAY), 'DANG_MUON', 4),
                                                                         (DATE_SUB(NOW(), INTERVAL 15 DAY), DATE_SUB(NOW(), INTERVAL 5 DAY), 'DA_TRA', 5);



INSERT INTO chi_tiet_phieu_muon (so_luong, ma_phieu_muon, ma_sach) VALUES
                                                                       (1, 1, 1),
                                                                       (2, 2, 2),
                                                                       (1, 3, 3),
                                                                       (1, 4, 4),
                                                                       (1, 5, 5);

select * from chi_tiet_phieu_muon    ;

