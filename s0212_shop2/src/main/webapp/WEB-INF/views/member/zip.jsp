<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title> JARDIN SHOP </title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="JARDIN" />
<meta name="keywords" content="JARDIN" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scaleable=no" />
<link rel="stylesheet" type="text/css" href="../css/reset.css" />
<link rel="stylesheet" type="text/css" href="../css/content.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
</head>
<body>
<div id="layerWrap">

	<div class="inputWrap">
			
		<div class="inputBody">
			<div class="title">우편번호 검색 </div>
			<p class="close"><a onclick="parent.$.fancybox.close();" href="javascript:;"><img src="../images/btn/btn_input_close.gif" alt="닫기" /></a></p>

			<p class="popalert">찾으실 지역의 동/읍/면 이름을 공백 없이 입력해 주세요.<br/>예) 여의도동, 오천읍, 수지면</p>

			<div class="addressChk">
				<ul>	
					<li><input type="radio" name="addresstype" id="old" class="radio_t" checked="checked"><label for="old">구주소 동/번지로 도로명주소 찾기</label></li>
					<li><input type="radio" name="addresstype" id="new" class="radio_t" value="new" ><label for="new">도로명/건물명 통합검색</label></li>
				</ul>
			</div>

			<div class="inputBox">					
				<ul class="old">
					<li><label for="">동(읍/면)</label><input type="text" class="w348" id="" /></li>
					<li><label for="">지번</label><input type="text" class="w348" id="" /></li>
				</ul>
				<ul class="new" style="display:none;">
					<li><label for="" class="wl130">도로명 or 건물번호</label><input type="text" class="w290" id="" /></li>
				</ul>
			</div>

			<div class="centerbrn">
				<a href="#">검색</a>
			</div>

			<div class="popDiv">
				<div class="popbd">
					<table summary="우편번호와 주소를 검색하실 수 있습니다." class="popTable" border="1" cellspacing="0">
						<caption>우편번호 검색</caption>
						<colgroup>
						<col width="20%" class="tw30"/>
						<col width="*" />
						</colgroup>
						<thead>
							<tr>
								<th scope="col">우편번호</th>
								<th scope="col" class="last">주소</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>123-1234</td>
								<td class="left">서울특별시 강남구 논현로 149길 62(논현동 4-21)</td>
							</tr>

							<tr>
								<td>&nbsp;</td>
								<td class="left">검색결과가 없습니다.</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>

	</div>


<script type="text/javascript">
$(function() {

	$('input[name=addresstype]').change(function () {
		if( $(this).val() === 'new' ){
			$('.new').show();
			$('.old').hide();
		}
		else{
			$('.new').hide();
			$('.old').show();
		}
	});

	$("input[value=day]").attr('checked', 'checked').trigger('change');

});

</script>

</div>
</body>
</html>