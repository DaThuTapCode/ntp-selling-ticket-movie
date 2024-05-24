create
database ntp_booking_movie;
use
ntp_booking_movie;

-- Bảng users lưu trữ thông tin người dùng
-- create table users(
-- 	id bigint auto_increment primary key,   -- Khóa chínhc của bảng users
--     userName varchar(100),				    -- Tên đăng nhập
--     fullName nvarchar(100),					-- Tên người dùng
--     password nvarchar(200),					-- Mật khẩu đã mã hóa
--     email nvarchar(500),					-- email
--     image text,								-- Lữu trữ ảnh người dùng
--     createdAt datetime,						-- Ngày tạo tài khoản
--     updateAt datetime,						-- Ngày sửa tài khoản
--     status varchar(100),				    -- Trạng thái tài khoản
--     unique key unique_email (email)         -- Check email là duy nhất không được trùng
-- );

-- Bảng roles lưu trữ thông tin vai trò của người dùng (ADMIN, USER...)
-- create table roles(
-- 	id bigint auto_increment primary key, -- Khóa chính
--     name varchar(100), -- tên vai trò
--     description text, -- Mô tả vai trò
--     createAt datetime -- Ngày tạo vai trò
-- );

-- Bảng userRoles Lưu trữ quan hệ giữa người dùng và vai trò.
-- create table userRoles(
-- 	id bigint auto_increment primary key, -- Khóa chính
--     userId bigint  not null, -- Khóa ngoại đến bảng users 1-n
--     roleId bigint not null, -- Khóa ngoại đến bảng roles 1-n
--     constraint fk_userRoles_user foreign key (userId) references users(id),
--     constraint fk_userRoles_roles foreign key (roleId) references roles(id)
-- );


-- Bảng users lưu trữ thông tin người dùng
create table users
(
    id               bigint auto_increment primary key, -- Khóa chínhc của bảng users
    roleId           bigint not null,                   -- Khóa ngoại phân quyền
    userName         varchar(100),                      -- Tên đăng nhập
    fullName         nvarchar(100),                     -- Tên người dùng
    password         nvarchar(200),                     -- Mật khẩu đã mã hóa
    email            nvarchar(500),                     -- email
    image            text,                              -- Lữu trữ ảnh người dùng
    createdAt        datetime,                          -- Ngày tạo tài khoản
    updateAt         datetime,                          -- Ngày sửa tài khoản
    faceBookAcountId nvarchar(300),
    googleAcountId   nvarchar(300),
    status           varchar(100),                      -- Trạng thái tài khoản
    unique key unique_email (email)                     -- Check email là duy nhất không được trùng
);


alter table users change column faceBookAcountId faceBookAcountId int;
alter table users change column googleAcountId googleAcountId int;
select *
from users;

-- Bảng roles lưu trữ thông tin vai trò của người dùng (ADMIN, USER...)
create table roles
(
    id          bigint auto_increment primary key, -- Khóa chính
    name        varchar(100),                      -- tên vai trò
    description text,                              -- Mô tả vai trò
    createAt    datetime                           -- Ngày tạo vai trò
);


-- Bảng movies lưu trữ thông tin về phim
create table movies
(
    id           bigint auto_increment primary key, -- Khóa chính
    title        nvarchar(300) not null,            -- Tiêu đề phim
    descriptions text,                              -- Mô tả về phim
    duration     int not null,                      -- Thời lượng phim
    releaseDate  date,                              -- Ngày khởi chiếu
    genre        nvarchar(100),                     -- Thể loại phim
    language     nvarchar(100),                     -- Ngôn ngữ phim
    performers   text,                              -- Diển viên
    director     nvarchar(200),                     -- Đạo diễn
    trailer      nvarchar(300),                     -- Đoạn giới thiệu phim
    image        text,                              -- Ảnh bìa mô tả phim
    status       int
);
-- Bảng theaters lưu trữ thông tin về rạp phim
create table theaters
(
    id          bigint auto_increment primary key, -- Khóa chính
    name        nvarchar(100) not null,            -- Tên rạp
    location    nvarchar (200) not null,           -- Địa chỉ rạp
    image       text,                              -- Ảnh mô tả rạp
    phone       nvarchar(200) not null,            -- Điện thoại liên hệ
    email       varchar(200) not null,             -- Email liên hệ rạp
    description text                               -- Mô tả về rạp
);


-- Bảng Screens Lưu trữ về màn  hình chiếu (phòng chiếu).
create table screens
(
    id        bigint auto_increment primary key, -- Khóa chính
    theaterId bigint       not null,             -- Khóa ngoại đến bảng theaters
    name      varchar(100) not null,             -- Tên phòng chiếu
    capacity  int          not null,             -- Số lượng ghế
    type      nvarchar (100),                    -- Loại phòng chiếu
    foreign key (theaterId) references theaters (id)
);

-- Bảng showTime lưu thông tin về các suất chiếu
create table showtimes
(
    id       bigint auto_increment primary key, -- Khóa chính
    movieId  bigint not null,                   -- Khóa ngoại đến bảng movies
    screenId bigint not null,                   -- Khóa ngoại đến bảng screens
    showDate date   not null,                   -- Ngày chiếu
    showTime time   not null,                   -- Giờ chiếu
    foreign key (movieId) references movies (id),
    foreign key (screenId) references screens (id)
);


-- Bảng seats lưu trữ thông tin về ghế ngồi
create table seats
(
    id         bigint auto_increment primary key, -- Khóa chính
    screenId   bigint      not null,              -- Khóa ngoại đến bảng screens
    seatNumber varchar(20) not null,              -- Số ghế
    type       varchar(20),                       -- Loại ghế
    foreign key (screenId) references screens (id)
);


-- Bảng booking lưu trữ thong tin về các giao dịch đặt vé
create table booking
(
    id          bigint auto_increment primary key, -- Khóa chính
    userId      bigint         not null,           -- Khóa ngoại đến users
    bookingDate timestamp      not null,           -- Ngày đặt vé
    total_price decimal(10, 2) not null,           -- Tổng số tiền thanh toán
    status      varchar(20)    not null,           -- Trạng thái giao dịch
    foreign key (userId) references users (id)
);

-- Bảng bookingDetail lưu trữ thông tin về các vé trong 1 giao dịch
create table bookingDetail
(
    id         bigint auto_increment primary key, -- Khóa chính
    bookingId  bigint         not null,           -- Khóa ngoại đến băng booking
    showTimeId bigint         not null,           -- Khóa ngoại đến showtimes
    seatId     bigint         not null,           -- Khóa ngoại đến seatId
    theaterId  bigint         not null,           -- Khóa ngoại đến theaters
    price      decimal(10, 2) not null,           -- Giá vé
    foreign key (bookingId) references booking (id),
    foreign key (theaterId) references theaters (id),
    foreign key (showTimeId) references showtimes (id),
    foreign key (seatId) references seats (id)
);

create table promotions
(
    id          bigint primary key,
    movieId     bigint not null,
    theaterId   bigint not null,
    title       nvarchar(300),
    image       text,
    description text,
    startDate   date,
    endDate     date,
    foreign key (movieId) references movies (id),
    foreign key (theaterId) references theaters (id)
);

create table event
(
    id          bigint auto_increment primary key,
    movieId     bigint not null,
    theaterId   bigint not null,
    name        nvarchar(200) not null,
    description text,
    image       text,
    eventDate   date   not null,
    location    nvarchar(200) not null,
    foreign key (movieId) references movies (id),
    foreign key (theaterId) references theaters (id)
);
-- hỗ trợ đăng nhập từ Facebook và Google
CREATE TABLE social_accounts
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    provider   VARCHAR(20)  NOT NULL COMMENT 'Tên nhà social network',
    providerId VARCHAR(50)  NOT NULL,
    email      VARCHAR(150) NOT NULL COMMENT 'Email tài khoản',
    name       VARCHAR(100) NOT NULL COMMENT 'Tên người dùng',
    userId     bigint,
    FOREIGN KEY (userId) REFERENCES users (id)
);

create table movieTicketPrices
(
    id        bigint auto_increment primary key,
    movieId   bigint not null,
    price     decimal(10, 2),
    dayOfWeek int    not null,
    startTime time   not null,
    endTime   time   not null,
    foreign key (movieId) references movies (id)
);
CREATE TABLE tokens
(
    id             int PRIMARY KEY AUTO_INCREMENT,
    token          varchar(255) UNIQUE NOT NULL,
    tokenType      varchar(50)         NOT NULL,
    expirationDate DATETIME,
    revoked        tinyint(1) NOT NULL,
    expired        tinyint(1) NOT NULL,
    userId         bigint,
    FOREIGN KEY (userId) REFERENCES users (id)
);
;
-- Insert dữ liệu vào bảng users
INSERT INTO users (userName, roleId, fullName, password, email, image, createdAt, updateAt, status)
VALUES ('phunt', 1, 'Nguyễn Trọng Phú', '130904', 'phunt1@example.com', 'image1.png', NOW(), NOW(), 'ACTIVE'),
       ('thaont', 2, 'Nguyễn Thanh Thảo', '123', 'thaont@example.com', 'image2.png', NOW(), NOW(), 'ACTIVE'),
       ('ngochn', 3, 'Ngô Hồng Ngọc', '123', 'ngochn@example.com', 'image3.png', NOW(), NOW(), 'ACTIVE');

-- Insert dữ liệu vào bảng roles
INSERT INTO roles (name, description, createAt)
VALUES ('ADMIN', 'Administrator role', NOW()),
       ('USER', 'User role', NOW()),
       ('MODERATOR', 'Moderator role', NOW());


select *
from users;
select *
from movies;


-- Insert dữ liệu vào bảng users
-- INSERT INTO users (userName, password, email, image, createdAt, updateAt, status) VALUES
-- ('phunt', '130904', 'phunt1@example.com', 'image1.png', NOW(), NOW(), 'ACTIVE'),
-- ('thaont', '123', 'thaont@example.com', 'image2.png', NOW(), NOW(), 'ACTIVE'),
-- ('ngochn', '123', 'ngochn@example.com', 'image3.png', NOW(), NOW(), 'ACTIVE');

-- Insert dữ liệu vào bảng roles
-- INSERT INTO roles (name, description, createAt) VALUES
-- ('ADMIN', 'Administrator role', NOW()),
-- ('USER', 'User role', NOW()),
-- ('MODERATOR', 'Moderator role', NOW());

-- Insert dữ liệu vào bảng userRoles
-- INSERT INTO userRoles (userId, roleId) VALUES
-- (1, 1),  -- user1 với vai trò ADMIN
-- (2, 2),  -- user2 với vai trò USER
-- (3, 3);  -- user3 với vai trò MODERATOR





