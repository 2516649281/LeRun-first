-- 校园跑腿
create database takeawaysystem;

use takeawaysystem;

-- 账号表
create table `account`
(
    account_id          int primary key auto_increment comment '用户编号',
    account_name        varchar(32) not null unique comment '用户名(账号)',
    account_password    varchar(32) not null comment '用户密码',
    account_deleted     varchar(1)  not null default 0 comment '冻结指数',
    account_create_time datetime    not null default CURRENT_TIMESTAMP comment '创建时间',
    account_update_time datetime    not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间'
);

-- 用户表
create table `user`
(
    user_id      int primary key auto_increment comment '用户编号',
    user_name    varchar(32) not null comment '用户姓名',
    user_age     int         not null comment '用户年龄',
    user_sex     varchar(4)  not null comment '用户性别',
    user_address varchar(64) not null comment '用户住址',
    user_phone   varchar(11) not null comment '手机号',
    user_duty    int         not null default 0 comment '用户职务(0 普通用户，1 接单员，2 跑腿员)',
    account_id   int comment '账号编号',
    constraint user_account_fk foreign key (account_id) references account (account_id)
);

-- 订单表
create table `order`
(
    order_id          int primary key auto_increment comment '订单编号',
    order_name        varchar(1024) not null comment '订单信息',
    user_id           int           not null comment '发起人编号',
    admin_id          int comment '接单员编号',
    run_id            int comment '跑腿员编号',
    order_create_time datetime      not null default CURRENT_TIMESTAMP comment '创建时间',
    order_update_time datetime      not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间',
    constraint user_order_fk foreign key (user_id) references user (user_id),
    constraint admin_order_fk foreign key (admin_id) references user (user_id),
    constraint run_account_fk foreign key (run_id) references user (user_id)
);

INSERT INTO `account` VALUES (1, 'SX73891415', 'JEW16TQQ0QD', '0', '2022-03-14 15:48:18', '2022-03-14 15:48:18');
INSERT INTO `account` VALUES (2, 'CT27972237', 'WYD77FNC8HH', '0', '2022-03-14 15:48:18', '2022-03-14 15:48:18');
INSERT INTO `account` VALUES (3, 'BT86742833', 'UUU45MDD1PX', '0', '2022-03-14 15:48:18', '2022-03-14 15:48:18');
INSERT INTO `account` VALUES (4, 'AG35326459', 'IEQ78CEB8EG', '0', '2022-03-14 15:48:18', '2022-03-14 15:48:18');
INSERT INTO `account` VALUES (5, 'PL35587756', 'LWK58ZFR2YN', '0', '2022-03-14 15:48:18', '2022-03-14 15:48:18');
INSERT INTO `account` VALUES (6, 'HS17381013', 'LXO04IEG5RB', '0', '2022-03-14 15:48:18', '2022-03-23 13:58:24');
INSERT INTO `account` VALUES (7, 'QQ16487072', 'PBU86EHU9RD', '0', '2022-03-14 15:48:18', '2022-03-14 15:48:18');
INSERT INTO `account` VALUES (8, 'LO10585378', 'YXJ83YVB0IK', '0', '2022-03-14 15:48:18', '2022-03-18 14:16:51');
INSERT INTO `account` VALUES (9, 'KX51871885', 'RNJ71UYF9LU', '0', '2022-03-14 15:48:18', '2022-03-14 15:48:18');
INSERT INTO `account` VALUES (10, 'TH67244963', 'VWQ03WKO7TF', '0', '2022-03-14 15:48:18', '2022-09-28 16:24:58');
INSERT INTO `account` VALUES (11, '2516649281', '13597803422dw', '0', '2022-03-15 15:17:25', '2022-03-18 14:16:27');
INSERT INTO `account` VALUES (13, 'root', '12345678', '0', '2022-03-18 08:02:36', '2022-03-18 08:02:36');
INSERT INTO `account` VALUES (14, 'admin', '123456', '0', '2022-03-18 12:04:45', '2022-03-18 14:19:29');

INSERT INTO `order` VALUES (2, '食堂小碗菜，送到3-332', 1, 14, 15, '2022-03-19 16:47:20', '2022-03-21 16:37:40');
INSERT INTO `order` VALUES (3, '一包烟，送达3-223', 2, 14, 3, '2022-03-19 16:58:38', '2022-03-19 16:58:38');
INSERT INTO `order` VALUES (4, '1111', 1, 14, 15, '2022-03-22 10:47:40', '2022-03-22 10:47:40');
INSERT INTO `order` VALUES (18, '餐厅一楼带一碗盖浇饭', 1, 14, 15, '2022-03-24 10:34:50', '2022-03-24 10:34:50');
INSERT INTO `order` VALUES (19, '2222', 1, 14, 15, '2022-03-24 10:37:21', '2022-03-24 10:37:21');
INSERT INTO `order` VALUES (20, '3333', 1, 14, 15, '2022-03-24 10:38:11', '2022-03-24 10:38:11');
INSERT INTO `order` VALUES (22, '我要一份炸鸡，带到4-505宿舍', 14, 14, 8, '2022-06-30 06:51:17', '2022-06-30 06:51:17');
INSERT INTO `order` VALUES (23, '从食堂带一份热干面，加个卤蛋，送到3-506宿舍', 14, 14, 14, '2022-06-30 06:55:06', '2022-06-30 06:55:06');

INSERT INTO `user` VALUES (1, 'Venus Scott', 21, '女', 'Huádōng', '14263172605', 1, 1);
INSERT INTO `user` VALUES (2, 'Ryan Leach', 18, '女', 'Huádōng', '11842830895', 0, 2);
INSERT INTO `user` VALUES (3, 'Selma Foster', 21, '女', 'Xīnán', '18740665140', 2, 3);
INSERT INTO `user` VALUES (4, 'Lewis Sharpe', 25, '男', 'Zhōngnán', '12421948627', 0, 4);
INSERT INTO `user` VALUES (5, 'Jacqueline Hess', 18, '男', 'Huáběi', '13303745414', 1, 5);
INSERT INTO `user` VALUES (6, 'Burke Salazar', 23, '男', 'Xīběi', '12277130514', 0, 6);
INSERT INTO `user` VALUES (7, 'Deanna Bates', 19, '女', 'Xīběi', '18352631004', 0, 7);
INSERT INTO `user` VALUES (8, 'Xander Ray', 18, '女', 'Xīnán', '19876788737', 2, 8);
INSERT INTO `user` VALUES (9, 'Barrett Banks', 20, '女', 'Xīběi', '16871814856', 0, 9);
INSERT INTO `user` VALUES (10, 'Sybill Hartman', 24, '男', 'Huádōng', '11275747137', 1, 10);
INSERT INTO `user` VALUES (12, '小红', 19, '女', '北京', '15698243658', 0, 11);
INSERT INTO `user` VALUES (14, '小明', 20, '男', '上海', '15698235469', 1, 13);
INSERT INTO `user` VALUES (15, '小花', 19, '女', '上海', '15987463258', 2, 14);
