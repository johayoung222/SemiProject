<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int year = 2019;
	int month = 1;
	int day = 4;
%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<style>
#schedule{
    width: 80%;
    height: 80%;
    position: relative;
    bottom: 0;
    right: 0;
    border: 1px solid black;
}
#main{
    width: 250px;
    height: 40px;
    margin: 0 auto;
    position: relative;
}
#main span{
    display: inline-block;
    position: relative;
    margin-left: 20px;
    font-size: 20px;
    font-weight: bold;
}
#month{
    width: 100%;
    border-collapse: collapse;

}
#month tr{
    height: 20px;
}
#month th{
    border-top: 1px solid blue;
}
#month td{
    height: 100px;
    border: 1px solid blue;
    padding: 0;
    margin-top: 0;
    position: relative;
}
#month td span{
    position: absolute;
    top: 0px;
}
</style>

	<div id="schedule">
		<div id="main">
            <span>&lt;</span>
            <span>2019년</span>
            <span>1월</span>
            <span>&gt;</span>
        </div>
		<table id="month">
			<tr>
				<th>일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th>토</th>
			</tr>
			<tr>
				<td><span></span></td>
				<td><span></span></td>
				<td><span>1</span></td>
				<td><span>2</span></td>
				<td><span>3</span></td>
				<td><span>4</span></td>
				<td><span>5</span></td>
			</tr>
			<tr>
				<td><span>6</span></td>
				<td><span>7</span></td>
				<td><span>8</span></td>
				<td><span>9</span></td>
				<td><span>10</span></td>
				<td><span>11</span></td>
				<td><span>12</span></td>
			</tr>
			<tr>
				<td><span>13</span></td>
				<td><span>14</span></td>
				<td><span>15</span></td>
				<td><span>16</span></td>
				<td><span>17</span></td>
				<td><span>18</span></td>
				<td><span>19</span></td>
			</tr>
			<tr>
				<td><span>20</span></td>
				<td><span>21</span></td>
				<td><span>22</span></td>
				<td><span>23</span></td>
				<td><span>24</span></td>
				<td><span>25</span></td>
				<td><span>26</span></td>
			</tr>
			<tr>
				<td><span>27</span></td>
				<td><span>28</span></td>
				<td><span>29</span></td>
				<td><span>30</span></td>
				<td><span>31</span></td>
				<td><span></span></td>
				<td><span></span></td>
			</tr>
		</table>
	</div>
</body>
</html>