<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>社員管理マスター登録画面</title>
</head>
<body>
	<h1>社員管理マスター登録画面</h1>
	<hr />

	<f:form modelAttribute="employeeModel" action="regist" method="post">
		<table>
			<tr>
				<td width="120">氏名</td>
				<td>
					<div>
						<input type="text" name="name" />
						<f:errors path="name" element="div" cssStyle="color:red" />
					</div>
				</td>
			</tr>
			<tr>
				<td>フリガナ</td>
				<td><f:input path="kana" size="50" /></td>
			</tr>
			<tr>
				<td>性別</td>
				<td><f:radiobutton path="gender" label="男" value="0"
						checked="true" /> <f:radiobutton path="gender" label="女"
						value="1" /></td>
			</tr>
			<tr>
				<td>生年月日</td>
				<td><form:select path="bYear" items="${bYears }"
						itemLabel="label" itemValue="data" />年&nbsp; <form:select
						path="bMonth" items="${months}" itemLabel="label" itemValue="data" />月&nbsp;
					<form:select path="bDay" items="${days}" itemLabel="label"
						itemValue="data" />日&nbsp;</td>
			</tr>
			<tr>
				<td>郵便番号</td>
				<td><form:input path="zip" size="10" /></td>
			</tr>
			<tr>
				<td>住所</td>
				<td><form:input path="address" size="100" /></td>
			</tr>
			<tr>
				<td>携帯番号</td>
				<td><form:input path="phone" size="15" /></td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td><form:input path="mail" size="50" /></td>
			</tr>
			<tr>
				<td>入社年月日</td>
				<td><form:select path="eYear" items="${eYears }"
						itemLabel="label" itemValue="data" />年&nbsp; <form:select
						path="eMonth">
						<form:options items="${months}" itemLabel="label" itemValue="data" />

					</form:select>月&nbsp; <form:select path="eDay" items="${days}" itemLabel="label"
						itemValue="data" />日&nbsp;</td>
			</tr>
			<tr>
				<td>部署</td>
				<td><form:select path="post" items="${post}" itemLabel="label"
						itemValue="label" /></td>
			</tr>
			<tr>
				<td>上司名</td>
				<td><form:input path="superior" size="50" /></td>
			</tr>
			<tr>
				<td>最寄駅</td>
				<td><form:input path="station" size="50" /></td>
			</tr>
			<tr>
				<td>給与ランク</td>
				<td><form:select path="rank" items="${rank}" itemLabel="label"
						itemValue="data"></form:select></td>
			</tr>
			<tr>
				<td>保有資格</td>
				<td><form:checkboxes items="${capacities}" path="capacities"
						itemLabel="label" itemValue="data" delimiter="<br />" /></td>
			</tr>
			<tr>
				<td>
					<div>
						<input type="submit" value="ログイン" />
					</div>
				</td>
			</tr>
		</table>


	</f:form>
</body>
</html>