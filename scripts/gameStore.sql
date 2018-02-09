
--
-- Servidor: localhost
-- Tiempo de generación: 27 eNERO 2018
-- Versión del servidor: 5.6 


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gamestore`
--
create database gamestore;
use gamestore;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customer`
--



CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL serial default value auto_increment,
  `customer_code` varchar(50),
  `customer_name` varchar(50),
  `customer_address` varchar(50),
  `customer_otherdetails` text, 
  primary key (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customer_orders`
--

CREATE TABLE `customer_orders` (
  `order_id` int(11)  NOT NULL serial default value auto_increment,
  `date_of_order` date,
  `other_order_details` text,
  `customer_id` int(11)  NOT NULL,
  foreign key (customer_id) references customer (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customer_purchases`
--

CREATE TABLE `customer_purchases` (
  `purchase_id` int(11) NOT NULL  serial default value auto_increment,
  `date_of_purchase` date,
  `other_purchase_detail` text,
  `customer_id` int(11)  NOT NULL,
  foreign key (customer_id) references customer (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



