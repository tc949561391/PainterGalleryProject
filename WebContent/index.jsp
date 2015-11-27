<%@page import="com.market.pageinfo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ch">

<head>

<!-- Basic -->
<meta charset="UTF-8" />

<title>总体预览 | Fire - Admin Template</title>

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<!-- Import google fonts -->
<link href='http://fonts.useso.com/css?family=Titillium+Web'
	rel='stylesheet' type='text/css'>

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.ico"
	type="image/x-icon" />
<link rel="apple-touch-icon" href="assets/ico/apple-touch-icon.png" />
<link rel="apple-touch-icon" sizes="57x57"
	href="assets/ico/apple-touch-icon-57x57.png" />
<link rel="apple-touch-icon" sizes="72x72"
	href="assets/ico/apple-touch-icon-72x72.png" />
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/ico/apple-touch-icon-76x76.png" />
<link rel="apple-touch-icon" sizes="114x114"
	href="assets/ico/apple-touch-icon-114x114.png" />
<link rel="apple-touch-icon" sizes="120x120"
	href="assets/ico/apple-touch-icon-120x120.png" />
<link rel="apple-touch-icon" sizes="144x144"
	href="assets/ico/apple-touch-icon-144x144.png" />
<link rel="apple-touch-icon" sizes="152x152"
	href="assets/ico/apple-touch-icon-152x152.png" />

<!-- start: CSS file-->

<!-- Vendor CSS-->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="assets/vendor/skycons/css/skycons.css" rel="stylesheet" />
<link href="assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="assets/vendor/css/pace.preloader.css" rel="stylesheet" />

<!-- Plugins CSS-->
<link href="assets/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css"
	rel="stylesheet" />
<link href="assets/plugins/scrollbar/css/mCustomScrollbar.css"
	rel="stylesheet" />
<link href="assets/plugins/bootkit/css/bootkit.css" rel="stylesheet" />
<link href="assets/plugins/magnific-popup/css/magnific-popup.css"
	rel="stylesheet" />
<link href="assets/plugins/fullcalendar/css/fullcalendar.css"
	rel="stylesheet" />
<link href="assets/plugins/jqvmap/jqvmap.css" rel="stylesheet" />

<!-- Theme CSS -->
<link href="assets/css/jquery.mmenu.css" rel="stylesheet" />

<!-- Page CSS -->
<link href="assets/css/style.css" rel="stylesheet" />
<link href="assets/css/add-ons.min.css" rel="stylesheet" />

<!-- end: CSS file-->


<!-- Head Libs -->
<script src="assets/plugins/modernizr/js/modernizr.js"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>

	<!-- Start: Header -->
	

	<!-- Start: Content -->
	<div class="container-fluid content">
		<div class="row">
		<c:import url="/navigation.jsp"></c:import>

			

			<!-- Main Page -->
			<div class="main ">
				<!-- Page Header -->
				<div class="page-header">
					<div class="pull-left">
						<ol class="breadcrumb visible-sm visible-md visible-lg">
							<li><a href="index.jsp"><i class="icon fa fa-home"></i>Home</a></li>
							<li class="active"><i class="fa fa-laptop"></i>总体预览</li>
						</ol>
					</div>
					<div class="pull-right">
						<h2>总体预览</h2>
					</div>
				</div>
				<!-- End Page Header -->
				<div class="row">
					<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
						<div class="panel bk-widget bk-border-off">
							<div
								class="panel-body text-left bk-bg-white bk-padding-top-10 bk-padding-bottom-10">
								<div class="row">
									<div class="col-xs-4 bk-vcenter text-center">
										<div class="small-chart-wrapper">
											<div class="small-chart" id="sparklineBarweeklystats"></div>
											<script type="text/javascript">
												var sparklineBarweeklystatsData = [
														5, 6, 7, 2, 0, 4, 2, 4,
														2, 0, 4, 2, 4, 2, 0, 4 ];
											</script>
										</div>
										<strong>Weekly stats</strong>
									</div>
									<div class="col-xs-8 text-left bk-vcenter text-center">
										<small>DOWNLOAD: 60%</small>
										<div
											class="progress light progress-xs  progress-striped active bk-margin-bottom-10">
											<div class="progress-bar progress-bar-primary"
												role="progressbar" aria-valuenow="60" aria-valuemin="0"
												aria-valuemax="100" style="width: 60%;">
												<span class="sr-only">60% Complete</span>
											</div>
										</div>
										<small>PROCESSED: 88%</small>
										<div
											class="progress light progress-xs  progress-striped active bk-margin-bottom-10">
											<div class="progress-bar progress-bar-warning"
												role="progressbar" aria-valuenow="88" aria-valuemin="0"
												aria-valuemax="100" style="width: 88%;">
												<span class="sr-only">88% Complete</span>
											</div>
										</div>
										<small>SALE: 60%</small>
										<div
											class="progress light progress-xs  progress-striped active bk-margin-bottom-10">
											<div class="progress-bar progress-bar-success"
												role="progressbar" aria-valuenow="60" aria-valuemin="0"
												aria-valuemax="100" style="width: 60%;">
												<span class="sr-only">60% Complete</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
						<div class="panel bk-widget bk-border-off">
							<div class="panel-body bk-bg-very-light-gray">
								<h4 class="bk-margin-off-bottom bk-docs-font-weight-300">TOTAL
									PROFIT</h4>
								<div class="clearfix  bk-padding-top-10">
									<div class="pull-right bk-margin-left-15">
										<i class="fa fa-dollar fa-3x"></i>
									</div>
									<h1 class="bk-margin-off-top pull-right">73,695</h1>
								</div>
								<a><h6 class="text-right bk-padding-top-20 bk-margin-off">Withdraw</h6></a>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
						<div class="panel bk-widget bk-border-off">
							<div class="panel-body bk-bg-very-light-gray">
								<h4 class="bk-margin-off-bottom bk-docs-font-weight-300">CONVERSIONS</h4>
								<div class="clearfix bk-padding-top-20">
									<div class="text-center">
										<i class="fa fa-random fa-3x bk-fg-warning"></i>
									</div>
								</div>
								<h4 class="text-right bk-padding-top-15 bk-margin-off">369</h4>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="panel">
							<div class="panel-body">
								<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12">
									<div
										class="tabs tabs-bottom tabs-primary bk-margin-bottom-15 bk-margin-top-15">
										<div class="tab-content bk-bg-very-light-gray">
											<div id="adminCart" class="tab-pane active">
												<div class="row">
													<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
														<div id="adminChartUpdate" style="height: 198px"></div>
													</div>
												</div>
											</div>
											<div id="widget" class="tab-pane">
												<div class="row">
													<div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
														<div class="panel bk-widget bk-border-off">
															<div
																class="bk-bg-white  bk-border-very-light-gray bk-fg-danger bk-ltr bk-padding-15 bk-radius">
																<div class="row">
																	<div
																		class="col-xs-4 text-left bk-vcenter bk-padding-off">
																		<span
																			class="bk-round bk-icon bk-icon-2x bk-bg-danger bk-border-off">
																			<i class="fa fa-users fa-2x"></i>
																		</span>
																	</div>
																	<div class="col-xs-8 text-left bk-vcenter">
																		<h6 class="bk-margin-off">TOTAL USERS</h6>
																		<strong class="bk-margin-off">326,269</strong>
																	</div>
																</div>
																<div
																	class="progress light progress-striped active bk-margin-off-bottom bk-margin-top-10 bk-noradius"
																	style="height: 6px;">
																	<div class="progress-bar progress-bar-danger"
																		role="progressbar" aria-valuenow="90"
																		aria-valuemin="0" aria-valuemax="100"
																		style="width: 90%;">
																		<span class="sr-only">90% Complete</span>
																	</div>
																</div>
																<div class="bk-margin-top-10">
																	<div class="row">
																		<div class="col-xs-6">
																			<small>Monthly: 6,269</small>
																		</div>
																		<div class="col-xs-6 text-right">
																			<a href="#" class="bk-fg-danger bk-fg-darken"><small>View
																					details</small> <i class="fa fa-database"></i></a>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
														<div class="panel bk-widget bk-border-off">
															<div
																class="bk-bg-white bk-border-very-light-gray bk-fg-success bk-ltr bk-padding-15 bk-radius">
																<div class="row">
																	<div
																		class="col-xs-4 text-left bk-vcenter bk-padding-off">
																		<span
																			class="bk-round bk-border-off bk-icon bk-icon-2x bk-bg-success">
																			<i class="fa fa-download fa-2x"></i>
																		</span>
																	</div>
																	<div class="col-xs-8 text-left bk-vcenter">
																		<h6 class="bk-margin-off">DOWNLOAD</h6>
																		<strong class="bk-margin-off">1,256</strong>
																	</div>
																</div>
																<div
																	class="progress light progress-striped active bk-margin-off-bottom bk-margin-top-10 bk-noradius"
																	style="height: 6px;">
																	<div class="progress-bar progress-bar-success"
																		role="progressbar" aria-valuenow="80"
																		aria-valuemin="0" aria-valuemax="100"
																		style="width: 80%;">
																		<span class="sr-only">80% Complete</span>
																	</div>
																</div>
																<div class="bk-margin-top-10">
																	<div class="row">
																		<div class="col-xs-6">
																			<small>Stock: 32,269</small>
																		</div>
																		<div class="col-xs-6 text-right">
																			<a href="#" class="bk-fg-success bk-fg-darken"><small>View
																					details</small> <i class="fa fa-database"></i></a>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
														<div class="panel bk-widget bk-border-off">
															<div
																class="bk-bg-white  bk-border-very-light-gray bk-fg-warning bk-ltr bk-padding-15 bk-radius">
																<div class="row">
																	<div
																		class="col-xs-4 text-left bk-vcenter bk-padding-off">
																		<span
																			class="bk-round bk-border-off bk-icon bk-icon-2x bk-bg-warning">
																			<i class="fa fa-shopping-cart fa-2x"></i>
																		</span>
																	</div>
																	<div class="col-xs-8 text-left bk-vcenter">
																		<h6 class="bk-margin-off">PURCHASE</h6>
																		<strong class="bk-margin-off">$526,369</strong>
																	</div>
																</div>
																<div
																	class="progress light progress-striped active bk-margin-off-bottom bk-margin-top-10 bk-noradius"
																	style="height: 6px;">
																	<div class="progress-bar progress-bar-warning"
																		role="progressbar" aria-valuenow="80"
																		aria-valuemin="0" aria-valuemax="100"
																		style="width: 80%;">
																		<span class="sr-only">80% Complete</span>
																	</div>
																</div>
																<div class="bk-margin-top-10">
																	<div class="row">
																		<div class="col-xs-6">
																			<small>Top day: 11/25/2014</small>
																		</div>
																		<div class="col-xs-6 text-right">
																			<a href="#" class="bk-fg-warning bk-fg-darken"><small>View
																					details</small> <i class="fa fa-database"></i></a>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="text-center">
													<p>Fire Admin Transaction Activity</p>
												</div>
											</div>
										</div>
										<ul class="nav nav-tabs nav-right">
											<li class="active"><a href="#adminCart"
												data-toggle="tab"> Fire Admin</a></li>
											<li><a href="#widget" data-toggle="tab"> Widget
													Update</a></li>
										</ul>
									</div>
								</div>

								<div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
									<div class="text-center bk-margin-bottom-15 bk-margin-top-15">
										<canvas id="polarArea" height="215" width="215"></canvas>
									</div>
									<h4 class="text-center">Monthly Sales</h4>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12">

						<div class="panel">
							<div
								class="panel-heading panel-heading-transparent bk-border-off">
								<h6>
									<strong>Market Inventory</strong>
								</h6>
								<div class="panel-actions">
									<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i></a>
									<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
								</div>
							</div>
							<div class="panel-body">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 text-center">
									<h4 class="bk-fg-warning">Best Seller</h4>
									<div id="piechart" style="height: 280px"></div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 text-center">
									<h4 class="bk-fg-warning">Marketplace Area</h4>
									<canvas id="radar" height="280" width="220"></canvas>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">


						<div class="panel panel-default">
							<div class="panel-heading bk-bg-white">
								<h6>
									<span class="label label-danger bk-margin-5">165</span>Friends
								</h6>
								<div class="panel-actions">
									<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i></a>
									<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
								</div>
							</div>
							<div class="panel-body">
								<a class="bk-bg-white bk-padding-off-top bk-padding-off-bottom">
									<div class="row">
										<div class="col-xs-3 bk-vcenter text-center bk-padding-10">
											<div class="bk-avatar">
												<img src="assets/img/avatar1.jpg" alt=""
													class="img-circle bk-img-40 bk-border-primary bk-border-2x bk-border-darken">
											</div>
										</div>
										<div class="col-xs-9 bk-vcenter">
											<h5 class="bk-fg-primary bk-fg-darken bk-margin-off-bottom">John
												Doe</h5>
											<p>Nullam vitae arcu in leo molestie hendrerit at quis
												sem.</p>
										</div>
									</div>
								</a>
								<hr class="bk-margin-off">
								<a class="bk-bg-white bk-padding-off-top bk-padding-off-bottom">
									<div class="row">
										<div class="col-xs-3 bk-vcenter text-center bk-padding-10">
											<div class="bk-avatar">
												<img src="assets/img/avatar2.jpg" alt=""
													class="img-circle bk-img-40 bk-border-warning bk-border-2x bk-border-darken">
											</div>
										</div>
										<div class="col-xs-9 bk-vcenter">
											<h5 class="bk-fg-warning bk-fg-darken bk-margin-off-bottom">John
												Doe</h5>
											<p>Nunc vitae porttitor purus.</p>
										</div>
									</div>
								</a>
								<hr class="bk-margin-off">
								<a class="bk-bg-white bk-padding-off-top bk-padding-off-bottom">
									<div class="row">
										<div class="col-xs-3 bk-vcenter text-center bk-padding-10">
											<div class="bk-avatar">
												<img src="assets/img/avatar2.jpg" alt=""
													class="img-circle bk-img-40 bk-border-danger bk-border-2x bk-border-darken">
											</div>
										</div>
										<div class="col-xs-9 bk-vcenter">
											<h5 class="bk-fg-danger bk-fg-darken bk-margin-off-bottom">John
												Doe</h5>
											<p>Morbi interdum posuere ultricies. Aliquam sit amet
												neque nisi.</p>
										</div>
									</div>
								</a>
								<hr class="bk-margin-off">
								<div class="panel-footer bk-bg-white">
									<div class="bk-padding-top-5 bk-padding-bottom-5 ">
										<div class="row">
											<div class="col-xs-6">
												<a href="#" class="bk-fg-textcolor"><small><i
														class="fa fa-angle-left"></i> PREVIOUS</small></a>
											</div>
											<div class="col-xs-6 text-right">
												<a href="#" class="bk-fg-textcolor"><small>NEXT
														<i class="fa fa-angle-right"></i>
												</small></a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">

						<div class="panel panel-transparent">
							<div class="panel-heading">
								<h6>
									<strong>Company Schedule Activity</strong>
								</h6>
								<div class="panel-actions">
									<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i></a>
									<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
								</div>
							</div>
							<div class="panel-body">
								<div class="timelineProfile timeline-profile">
									<div class="timeline-body">
										<div class="timeline-title">
											<h5 class="text-uppercase">May 2014</h5>
										</div>
										<ol class="timeline-items">
											<li>
												<div class="timeline-box">
													<p class="text-muted">5 months ago.</p>
													<p>
														It's awesome when we find a good solution for our
														projects, Fire Admin is <span class="text-primary">#awesome</span>
													</p>
												</div>
											</li>
											<li>
												<div class="timeline-box">
													<p class="text-muted">5 months ago.</p>
													<p>What is your greatest projects for your
														Administrator?</p>
												</div>
											</li>
											<li>
												<div class="timeline-box">
													<p class="text-muted">5 months ago.</p>
													<p>Checkout! How cool is that!</p>
													<div class="img-timeline">
														<a class="img-thumbnail lightbox"
															href="assets/img/gallery/photo6.jpg"
															data-plugin-options='{ "type":"image" }'> <img
															class="img-responsive" width="215"
															src="assets/img/gallery/photo6.jpg"> <span
															class="zoom"> <i class="fa fa-search"></i>
														</span>
														</a>
													</div>
												</div>
											</li>
										</ol>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
						<div class="panel">
							<div
								class="panel-heading panel-heading-transparent bk-border-off">
								<h6>
									<strong>Employes Stats</strong>
								</h6>
								<div class="panel-actions">
									<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i></a>
									<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
								</div>
							</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table
										class="table table-striped table-bordered bootstrap-datatable datatable">
										<thead>
											<tr>
												<th>Employe</th>
												<th>Position</th>
												<th>Salary</th>
												<th>Status</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>Willson</td>
												<td>Developer</td>
												<td>2563$</td>
												<td><span class="label label-warning">Pending</span></td>
											</tr>
											<tr>
												<td>James</td>
												<td>SEO</td>
												<td>5000$</td>
												<td><span class="label label-warning">Pending</span></td>
											</tr>
											<tr>
												<td>Steven</td>
												<td>Photographer</td>
												<td>1269$</td>
												<td><span class="label label-success">Success</span></td>
											</tr>
											<tr>
												<td>Aselay</td>
												<td>Project manger</td>
												<td>6253$</td>
												<td><span class="label label-danger">Failed</span></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>

						<div class="panel">
							<div
								class="panel-heading panel-heading-transparent bk-border-off">
								<h6>
									<strong>Calendar</strong>
								</h6>
								<div class="panel-actions">
									<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i></a>
									<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
								</div>
							</div>
							<div class="panel-body">
								<div class="calendar calendar-small">
									<div id="calendar"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- End Main Page -->

			<!-- Footer -->
			<div id="footer">
				<ul>
					<li>
						<div class="title">Memory</div>
						<div class="bar">
							<div class="progress light progress-sm  progress-striped active">
								<div class="progress-bar progress-squared progress-bar-success"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100" style="width: 60%;">60%</div>
							</div>
						</div>
						<div class="desc">4GB of 8GB</div>
					</li>
					<li>
						<div class="title">HDD</div>
						<div class="bar">
							<div class="progress light progress-sm  progress-striped active">
								<div class="progress-bar progress-squared progress-bar-primary"
									role="progressbar" aria-valuenow="40" aria-valuemin="0"
									aria-valuemax="100" style="width: 40%;">40%</div>
							</div>
						</div>
						<div class="desc">250GB of 1TB</div>
					</li>
					<li>
						<div class="title">SSD</div>
						<div class="bar">
							<div class="progress light progress-sm  progress-striped active">
								<div class="progress-bar progress-squared progress-bar-warning"
									role="progressbar" aria-valuenow="70" aria-valuemin="0"
									aria-valuemax="100" style="width: 70%;">70%</div>
							</div>
						</div>
						<div class="desc">700GB of 1TB</div>
					</li>
					<li>
						<div class="copyright">
							<p class="text-muted text-right">
								Fire <i class="fa fa-coffee"></i> Collect from <a
									href="http://www.cssmoban.com/" title="ç½é¡µæ¨¡æ¿"
									target="_blank">ç½é¡µæ¨¡æ¿</a> - More Templates <a
									href="http://www.cssmoban.com/" target="_blank"
									title="æ¨¡æ¿ä¹å®¶">æ¨¡æ¿ä¹å®¶</a>
							</p>
						</div>
					</li>
				</ul>
			</div>
			<!-- End Footer -->

		</div>
	</div>
	<!--/container-->


	<div class="clearfix"></div>


	<!-- start: JavaScript-->

	<!-- Vendor JS-->
	<script src="assets/vendor/js/jquery.min.js"></script>
	<script src="assets/vendor/js/jquery-2.1.1.min.js"></script>
	<script src="assets/vendor/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/skycons/js/skycons.js"></script>
	<script src="assets/vendor/js/pace.min.js"></script>

	<!-- Plugins JS-->
	<script src="assets/plugins/jquery-ui/js/jquery-ui-1.10.4.min.js"></script>
	<script
		src="assets/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="assets/plugins/bootkit/js/bootkit.js"></script>
	<script src="assets/plugins/magnific-popup/js/magnific-popup.js"></script>
	<script src="assets/plugins/moment/js/moment.min.js"></script>
	<script src="assets/plugins/fullcalendar/js/fullcalendar.js"></script>
	<script src="assets/plugins/flot/js/jquery.flot.min.js"></script>
	<script src="assets/plugins/flot/js/jquery.flot.pie.min.js"></script>
	<script src="assets/plugins/flot/js/jquery.flot.resize.min.js"></script>
	<script src="assets/plugins/flot/js/jquery.flot.stack.min.js"></script>
	<script src="assets/plugins/flot/js/jquery.flot.time.min.js"></script>
	<script src="assets/plugins/flot-tooltip/js/jquery.flot.tooltip.js"></script>
	<script src="assets/plugins/chart-master/js/Chart.js"></script>
	<script src="assets/plugins/jqvmap/jquery.vmap.js"></script>
	<script src="assets/plugins/jqvmap/data/jquery.vmap.sampledata.js"></script>
	<script src="assets/plugins/jqvmap/maps/jquery.vmap.world.js"></script>
	<script src="assets/plugins/sparkline/js/jquery.sparkline.min.js"></script>

	<!-- Theme JS -->
	<script src="assets/js/jquery.mmenu.min.js"></script>
	<script src="assets/js/core.min.js"></script>

	<!-- Pages JS -->
	<script src="assets/js/pages/index.js"></script>

	<!-- end: JavaScript-->

</body>

</html>