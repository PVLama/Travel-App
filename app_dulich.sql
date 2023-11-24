-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 11, 2023 lúc 03:51 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `app_dulich`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dacsan`
--

CREATE TABLE `dacsan` (
  `ID` int(11) NOT NULL,
  `Tenmonan` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Hinhanh` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `Mota` varchar(5000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idMonan` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `dacsan`
--

INSERT INTO `dacsan` (`ID`, `Tenmonan`, `Hinhanh`, `Mota`, `idMonan`) VALUES
(1, 'Dê Núi Ninh Bình', 'https://res.klook.com/image/upload/fl_lossy.progressive,q_85/c_fill,w_1000/v1617269701/blog/zbox5pws4oaoszuiyxho.webp', 'Được chăn thả bên trên những ngọn núi đá nên thịt dê ở Ninh Bình vô cùng săn chắc và dai nên du khách đến Ninh Bình nhất định phải thử món ăn này một lần. Trong khi thịt dê ở đây còn được chế biến ra nhiều món ăn ngon với những cách chế biến không giống nhau như làm thành nem dê, dê hấp, dê nướng hay nổi tiếng nhất là dê tương gừng - một món ăn cực kỳ giàu dinh dưỡng. Nhiều người cũng bảo rằng thịt dê còn có thể chữa được rất nhiều loại bệnh, nên đến Ninh Bình nếu có cơ hội bạn chớ bỏ lỡ thịt dê núi nức tiếng nơi đây.', 1),
(2, 'Xôi Trứng Kiến', 'https://res.klook.com/image/upload/fl_lossy.progressive,q_85/c_fill,w_1000/v1617269720/blog/cr3ypw3h9v59lhlhxcvd.webp', 'Nhiều người nhầm tưởng rằng những món ăn làm từ trứng kiến chỉ có ở khu vực vùng núi phía Bắc mà thôi nhưng ở ngay tại Ninh Bình cũng có một món ăn đặc sản làm từ trứng kiến với tên gọi xôi trứng kiến. Trứng kiến Ninh Bình có nguồn gốc từ vùng núi đá vôi Nho Quan. Người dân mang trứng kiến non về, sau đó rửa cho sạch rồi tẩm ướp gia vị, cuối cùng là xào chín. Món ăn này kết hợp với xôi, thêm hành khô thì hương vị phải nói cực kỳ lạ miệng và hấp dẫn vô cùng.', 1),
(3, 'Gỏi Cá Nhệch', 'https://res.klook.com/image/upload/fl_lossy.progressive,q_85/c_fill,w_1000/v1617269737/blog/v2wrdyy2ixxevmrlcqqt.webp', 'Đặc sản Ninh Bình - Gỏi cá Nhệch là món ăn ngon và nổi tiếng đối với người dân bản xứ Kim Sơn - Ninh Bình. Gỏi được chế biến tinh tế và công phu, trải qua nhiều giai đoạn để loại bỏ mùi tanh và có vị ngọt xen lẫn vị thơm của nếp. Món nước chấm gỏi dùng riêng cho gỏi cũng không hề đơn giản khi kết hợp vừa đủ giữa vị cay nồng của ớt, của sả và hạt tiêu. Chính sự cầu kỳ đó sẽ khiến khách du lịch ăn một lần mà nhớ một đời!', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhsach_diadanh`
--

CREATE TABLE `danhsach_diadanh` (
  `ID` int(10) NOT NULL,
  `Tendiadanh` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Tendiadiem` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Hinhanh` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `Hinhanh1` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `Hinhanh2` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `Hinhanh3` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `Mota` varchar(5000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Loai` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `danhsach_diadanh`
--

INSERT INTO `danhsach_diadanh` (`ID`, `Tendiadanh`, `Tendiadiem`, `Hinhanh`, `Hinhanh1`, `Hinhanh2`, `Hinhanh3`, `Mota`, `Loai`) VALUES
(1, 'Tràng An', 'Ninh Bình', 'https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2017/06/Trang-an-ninh-binh-1.jpg', 'https://cungphuot.info/wp-content/uploads/2016/07/kinh-nghiem-du-lich-trang-an.jpg', 'https://media.cungphuot.info/2018/04/20630/gioi-thieu-chung-ve-trang-an.jpg', 'https://media.cungphuot.info/2018/04/20630/lich-su-trang-an.jpg', 'Quần thể danh thắng Tràng An là một vùng du lịch tổng hợp gồm các di sản văn hóa và thiên nhiên thế giới do UNESCO công nhận ở Ninh Bình, Việt Nam. Trước đó, nhiều di tích danh thắng nơi đây đã được Chính phủ Việt Nam xếp hạng di tích quốc gia đặc biệt quan trọng như Khu du lịch sinh thái Tràng An, khu du lịch Tam Cốc - Bích Động, chùa Bái Đính, cố đô Hoa Lư... Liên kết giữa các khu vực này là hệ sinh thái rừng đặc dụng Hoa Lư trên núi đá vôi, đất ngập nước và hệ thống sông, hồ, đầm với diện tíc', 2),
(2, 'Côn Sơn', 'Hải Dương', 'https://media.truyenhinhdulich.vn/upload/news/236_di_tich_lich_su_con_son.png', 'https://media.truyenhinhdulich.vn//upload/news/10_2018/40f946b616ae955e423b3ca69c5dc6cf.jpg', 'https://luhanhvietnam.com.vn/du-lich/vnt_upload/news/03_2021/chua-con-son-solue9.jpg', 'https://luhanhvietnam.com.vn/du-lich/vnt_upload/news/03_2021/chua-con-son-S.jpg', ' Núi Côn Sơn (dân gian thường gọi là núi Hun) cao gần 200m dài trên 1km thuộc xã Cộng Hòa, huyện Chí Linh. Núi có hình con sư tử khổng lồ sau những năm tháng viễn du đã chọn nơi đây làm điểm dừng chân vĩnh viễn. Phía Bắc Côn Sơn giáp núi Ngũ Nhạc, cao 238m, trên đỉnh có miếu thờ thần gọi là “Ngũ Nhạc linh từ”, phía Tây tiếp nối với núi U Bò và một thung lũng xanh tươi những lũy tre, tiếp đó là núi Phượng Hoàng, có rừng thông bát ngát, suối trong rì rào, đá núi lô xô, chùa tháp cổ kính với 72 ngọn núi ngoạn mục', 1),
(3, 'Biển Sầm Sơn', 'Thanh Hóa', 'https://images.baoquangnam.vn/Storage/NewsPortal/2020/3/11/85416/Du-Lich-Thanh-Hoa-1.jpg', 'https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2017/08/biensamson.jpg', 'https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2017/08/biensamson2.jpg', 'https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2017/08/hontrongmai.jpg', 'Sầm Sơn là bãi biển nổi tiếng nhất của Thanh Hóa, cách Hà Nội khoảng 180 km và TP Thanh Hóa khoảng 16 km. Bãi biển Sầm Sơn có hình trăng khuyết, chạy dài 9 km từ chân núi Trường Lệ đến xã Quảng Cư (thị xã Sầm Sơn), rộng hàng nghìn mét, bằng phẳng, cát mịn, không có chỗ quá sâu, lầy thụt hoặc đá ngầm.', 1),
(4, 'Chùa Tam Chúc', 'Hà Nam', 'https://vietnamtravel.com/images/2021/01/tam-chuc-pagoda-thumbnail.jpg', 'https://avatars.mds.yandex.net/i?id=b2e2c464c93bb28579439ce7851e0e61-4855126-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=2a0000017a0eb7ebabdec23c5d65ab1e46fd-4621682-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=b4c8cb90ec7f5b9974f0e0e3c42c5752-4577278-images-thumbs&n=13', 'Sầm Sơn là bãi biển nổi tiếng nhất của Thanh Hóa, cách Hà Nội khoảng 180 km và TP Thanh Hóa khoảng 16 km. Bãi biển Sầm Sơn có hình trăng khuyết, chạy dài 9 km từ chân núi Trường Lệ đến xã Quảng Cư (thị xã Sầm Sơn), rộng hàng nghìn mét, bằng phẳng, cát mịn, không có chỗ quá sâu, lầy thụt hoặc đá ngầm.', 2),
(5, 'Hồ Hoàn Kiếm', 'Hà Nội', 'https://upload.wikimedia.org/wikipedia/commons/7/79/Thap_Rua.jpg', 'https://avatars.mds.yandex.net/i?id=025d788f698dad32ae674763589cc27e-5341398-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=b05186a19fa369cd2b0e39a065e6ce11f8bbc61c-5392430-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=eb2e474c06647ca67ac9aec05eeb36a664ced459-6441855-images-thumbs&n=13', 'Hồ Hoàn Kiếm là một trong những thắng cảnh của Thủ Đô Hà Nội, đây là một di tích có lịch sử ngàn năm văn hiến. Hồ Hoàn Kiếm hay còn gọi với cái tên là Hồ Gươm, được du khách nước ngoài gọi là \"Lẵng hoa giữa lòng thành phố\". Đây không chỉ là nơi hóng gió, dạo mát với xung quanh là nhiều loài hoa, cây cảnh, có tháp, có rùa,...mà nơi đây còn gắn liền với những hoạt động đời sống của người dân Thủ Đô...', 2),
(6, 'Núi Đôi Quản Bạ', 'Hà Giang', 'https://bazantravel.com/cdn/medias/uploads/27/27103-nui-doi-quan-ba.jpg', 'https://avatars.mds.yandex.net/i?id=6cf33dbc8a0e513d80c15ac60f8b3f22-5330858-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=0d446f6753cae22c4010701afd53a0a07863855a-6946905-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=8f0d855b703768fd99fea610c90931f5-5668913-images-thumbs&n=13', 'Núi Đôi Quản Bạ còn có tên gọi khác là Núi Đôi hoặc Núi Cô Tiên, có niên đại cách đây khoảng 1,6 triệu đến 2 triệu năm. Hai quả núi có hình dáng tròn trịa, đầy quyến rũ, trông giống như đôi gò bồng đảo căng tròn của nàng tiên đang say giấc nồng giữa núi rừng kỳ vĩ.', 1),
(7, 'Đảo Bali', 'Indonesia', 'http://dulichdisanviet.vn/lib/ckeditor/images/dao-bali-indonesia.jpg', 'https://avatars.mds.yandex.net/i?id=eedb05881bbc4eda7e1b9a7e7a90421981f5dc30-7120298-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=3a4bd098b18a415e9fe6c91b1c115fb5-4011528-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=8054c8f1156de5b8c4fde0d71dae8246-2459861-images-thumbs&n=13', 'ợc mệnh danh là hòn đảo thiên đường, du lịch Bali có một sức hấp dẫn không thể chối từ của một hòn đảo với bờ biển dài cát trắng, nắng vàng, nước xanh như lụa; của một nền văn hóa đặc sắc với những ngôi đền nước thiêng, những ngôi đền cổ nằm chênh vênh trên mỏm núi hay nhô ra đón sóng biển, là những thửa ruộng bậc thang ngút ngàn, là những ngọn núi lửa cao chót vót trên 3.000 mét, những dòng sông cuộn chảy, những khe núi sâu hun hút, những mặt hồ nguyên sơ trên miệng các dãy núi lửa và những cán', 2),
(8, 'Thủ đô London', 'England', 'http://asiawingstravel.com/wp-content/uploads/2022/02/dong-ho-bigben-london.jpg', 'https://avatars.mds.yandex.net/i?id=26e8248a2e36b7a3b92967e23b005d11-4570384-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=26e6edb0b9d9a85d1a3ec6c13ab24205a975d94d-5874919-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=8fe75e09f22071dc1759df29cf73cfbb-5513333-images-thumbs&n=13', 'Ở phía tây và phía bắc của Quảng trường Trafalgar là West End, khu mua sắm và giải trí chính ở London. Hầu hết các nhà hát lớn của London đều nằm ở đây, cũng như Nhà hát Opera Hoàng gia. Phố Oxford là một trong những con phố mua sắm nổi tiếng nhất thế giới. Chạy từ Tottenham Court Road ở phía đông đến Marble Arch ở phía tây, qua Oxford Circus, nơi nó băng qua Regent Street, đây là nơi có nhiều cửa hàng và cửa hàng bách hóa lớn (Self Ink, John Lewis, Marks và Spencer). Soho và Covent Garden là nh', 1),
(9, 'Paris', 'France', 'http://www.tugo.com.vn/wp-content/uploads/tugo22-21.jpg', 'https://avatars.mds.yandex.net/i?id=f5e9855d8d3e3cce0c0977f42bbb62bd28a40234-5233451-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=46495901639f99f0867510fb342bf6cd-5234700-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=9928d35a8193874deccf6493e7f294c2-5687696-images-thumbs&n=13', 'Không chỉ có 1 vẻ bề ngoài đẹp đẽ mà ẩn sâu bên trong Paris cũng không hề kém cạnh về những dấu ấn thăng trầm của lịch sử mà nước Pháp đã trải qua được lưu giữ cho đến tận ngày nay, khiến du khách không khỏi tò mò, mong muốn 1 lần du lịch Pháp để tận mắt ngắm nhìn Paris cho thỏa thích', 1),
(10, 'Cầu Vàng', 'Đà Nẵng', 'https://ik.imagekit.io/tvlk/blog/2022/02/dia-diem-du-lich-viet-nam-cover.jpeg', 'https://avatars.mds.yandex.net/i?id=8c7102d87bfbc9711a9303d4a9761d3d-3979623-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=a4534c1c0089f3d6aad37b7494013fa8-3703902-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=f7b41b5702a4010c176b5c541b2e5729-5241566-images-thumbs&n=13', 'Siêu phẩm Cây Cầu Vàng Đà Nẵng trên đỉnh Bà Nà Hill  khiến cánh báo giới quốc tế không ngớt lời ca ngợi. Với thiết kế vô cùng ấn tượng, hai bàn tay rêu phong to lớn vươn ra từ thân núi nắm lấy tấm lụa vàng lơ lửng giữa trời, tuyệt tác này còn được mọi người nhắc đến với cái tên Cầu Bàn Tay – một trong những địa điểm hấp dẫn không thể bỏ qua khi đi du lịch Đà Nẵng.', 1),
(11, 'Pù Luông', 'Thanh Hóa', 'https://stour.vn/uploads/attachments/cl2j7vfde003a01s0rueumvo0-124609635-3589003371159997-1966574582923712961-n.full.jpg', 'https://avatars.mds.yandex.net/i?id=162c35d156fb8971f2fe903642227f8dd80444d8-6955462-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=c432d945b217c4fc7d625568d6fe528e-6946680-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=3d8a40d5a92f0801f71f7708bf6e81a9-4575978-images-thumbs&n=13', 'Pù Luông những ngày này khoác lên mình màu xanh mơn mởn của những thửa ruộng bậc thang. Du khách đến nơi đây còn được hòa mình vào không khí trong lành của thiên nhiên.\n\nKhu bảo tồn thiên nhiên Pù Luông thuộc địa phận hai huyện Bá Thước và Quan Sơn, tỉnh Thanh Hóa. Pù Luông là tên gọi của đồng báo dân tộc Thái, có nghĩa là đỉnh núi cao nhất vùng.', 2),
(12, 'Đảo Phú Quốc', 'Kiên Giang', 'https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2018/09/dao-phu-quoc-kien-giang-vntrip1.jpg', 'https://avatars.mds.yandex.net/i?id=3c489186d25d9d251268f67ec17437ae1f4acb86-5178729-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=2a0000017a0294e416ba3408c29c2a406e66-4120780-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=b33b0d950a2ddfd515fe91d1b40b946c-5420588-images-thumbs&n=13', 'Không phải không có lý do mà Phú Quốc được ưu ái gọi tên là Đảo ngọc. Hòn đảo xinh đẹp nằm trong vịnh Thái Lan, thuộc tỉnh Kiên Giang này hiện là hòn đảo du lịch lớn nhất Việt Nam. Đảo ngọc Phú Quốc tiềm ẩn một sức hấp dẫn kì lạ, một thiên đường rực nắng giữa những hàng cây nhiệt đới xanh mát. Nếu bạn cũng yêu vùng “biển vắng”, muốn hòa mình vào làn nước trong lành và thiên nhiên hoang sơ thì Phú Quốc chính là lựa chọn tuyệt vời cho bạn trong hè này.', 1),
(15, 'Núi Đôi Quản Bạ', 'Hà Giang', 'https://bazantravel.com/cdn/medias/uploads/27/27103-nui-doi-quan-ba.jpg', 'https://avatars.mds.yandex.net/i?id=28bbdf04f603f4f9fb7414fbf14fdf55-5876168-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=6cf33dbc8a0e513d80c15ac60f8b3f22-5330858-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=8f0d855b703768fd99fea610c90931f5-5668913-images-thumbs&n=13', 'Núi Đôi Quản Bạ còn có tên gọi khác là Núi Đôi hoặc Núi Cô Tiên, có niên đại cách đây khoảng 1,6 triệu đến 2 triệu năm. Hai quả núi có hình dáng tròn trịa, đầy quyến rũ, trông giống như đôi gò bồng đảo căng tròn của nàng tiên đang say giấc nồng giữa núi rừng kỳ vĩ.', 1),
(16, 'singapore', 'singapore', 'https://avatars.mds.yandex.net/i?id=a8d8d5a0a9e03019d8125be37d1d61f8cbf673a8-4572119-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=f2449a85da84398e2c4b37766acb86c30182f863-4662459-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=baca25d3cde3e2ced7d55b7f2bf1b454-4884750-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=a3e4c9143294cd1be41aae1b07e3431dcd0a89cd-6323519-images-thumbs&n=13', 'con người thân thiện', 0),
(17, 'hải phòng', 'Thành phố hải phòng', 'https://avatars.mds.yandex.net/i?id=2a0000017a1a3e4bb58636abe76e9601ad4b-2955839-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=4bbf290fbb139827462f16e86c0816a6-5235970-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=c62e12cdbeb77624a9c4ce33549132ce741e1641-7000115-images-thumbs&n=13', 'https://avatars.mds.yandex.net/i?id=7064ee7efa89f7204aeb48009e2defbb2aa5311c-5417440-images-thumbs&n=13', 'đẹp tuyệt vời', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `ID` int(10) NOT NULL,
  `Tendangnhap` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sodienthoai` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Matkhau` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`ID`, `Tendangnhap`, `Email`, `Sodienthoai`, `Matkhau`) VALUES
(24, 'lamphamvan', 'lam@gmail.com', '01635580018', '12345678'),
(25, 'pham van lam', 'lampham@gmail.com', '01635580018', 'lam1205');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `dacsan`
--
ALTER TABLE `dacsan`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `idMonan` (`idMonan`);

--
-- Chỉ mục cho bảng `danhsach_diadanh`
--
ALTER TABLE `danhsach_diadanh`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `dacsan`
--
ALTER TABLE `dacsan`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `danhsach_diadanh`
--
ALTER TABLE `danhsach_diadanh`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `dacsan`
--
ALTER TABLE `dacsan`
  ADD CONSTRAINT `dacsan_ibfk_1` FOREIGN KEY (`idMonan`) REFERENCES `danhsach_diadanh` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
