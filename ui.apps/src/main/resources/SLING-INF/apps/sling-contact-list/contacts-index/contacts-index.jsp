<html>
<%@taglib prefix="sling" uri="http://sling.apache.org/taglibs/sling" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sling:defineObjects />
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sling Contacts App | Snippet - Bootsnipp.com</title>
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="/etc/sling-contact-list/css/style.css" rel="stylesheet">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="/etc/sling-contact-list/js/app.js" type="text/javascript" ></script>
</head>
    <body class="">
	
<div class="container">

    <div class="row">
        <div class="col-xs-12 col-sm-offset-3 col-sm-6">
            <div class="panel panel-default">
                <div class="panel-heading c-list">
                    <span class="title">Contacts</span>
                    <ul class="pull-right c-controls">
                        <li><a href="#addContactModal" data-toggle="tooltip" data-placement="top" title="" data-original-title="Add Contact"><i class="glyphicon glyphicon-plus"></i></a></li>
                        <li><a href="#" class="hide-search" data-command="toggle-search" data-toggle="tooltip" data-placement="top" title="" data-original-title="Toggle Search"><i class="fa fa-ellipsis-v"></i></a></li>
                    </ul>
                </div>
                
                <div class="row" style="display: none;">
                    <div class="col-xs-12">
                        <div class="input-group c-search">
                            <input type="text" class="form-control" id="contact-list-search">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search text-muted"></span></button>
                            </span>
                        </div>
                    </div>
                </div>
    
    		<%--
    		Using the Sling Taglibs to get the contacts resource
    		where the contacts are stored
    		 --%>
    		<sling:adaptTo adaptable="${slingRequest}" adaptTo="com.xicojunior.contacts.models.ContactList" var="contactList" />
                <ul class="list-group" id="contact-list">
                <c:set var="contacts" value="${contactList.contacts}" />
                <c:forEach var="contact" items="${contacts}" >
                	<li class="list-group-item">
                        <div class="col-xs-12 col-sm-3">
                        <c:if test="${not empty contact.contactImage }">
                            <img src="${contact.contactImage}" alt="${contact.name}" class="img-responsive img-circle">
                        </c:if>
                        </div>
                        <div class="col-xs-12 col-sm-9">
                            <span class="name">${contact.name}</span><br>
                            <span class="glyphicon glyphicon-map-marker text-muted c-info" data-toggle="tooltip" title="" data-original-title="${contact.address}"></span>
                            <span class="visible-xs"> <span class="text-muted">${contact.address}</span><br></span>
                            <span class="glyphicon glyphicon-earphone text-muted c-info" data-toggle="tooltip" title="" data-original-title="${contact.phone}"></span>
                            <span class="visible-xs"> <span class="text-muted">${contact.phone}</span><br></span>
                            <span class="fa fa-comments text-muted c-info" data-toggle="tooltip" title="" data-original-title="${contact.email}"></span>
                            <span class="visible-xs"> <span class="text-muted">${contact.email}</span><br></span>
                        </div>
                        <div class="clearfix"></div>
                    </li>
                </c:forEach>
                </ul>
            </div>
        </div>
	</div>
    
    <div id="addContactModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: none;">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="mySmallModalLabel">Add Contact</h4>
                </div>
                <div class="modal-body">
                    <form action="/content/contactsapp/contacts/*" method="post" enctype="multipart/form-data">
                        <fieldset class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name" placeholder="Enter your name" name="name">
                        </fieldset>
                        <fieldset class="form-group">
                            <label for="email">Email address</label>
                            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
                            <small class="text-muted">We'll never share your email with anyone else.</small>
                        </fieldset>
                        <fieldset class="form-group">
                            <label for="address">Address</label>
                            <input type="text" class="form-control" id="address" placeholder="Enter your name" name="address">
                        </fieldset>
                        <fieldset class="form-group">
                            <label for="phone">Phone</label>
                            <input type="text" class="form-control" id="phone" placeholder="Enter your phone" name="phone">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label for="contactImage">File input</label>
                            <input type="file" class="form-control-file" id="contactImage" name="contactImage">
                            <input type="hidden" name="contatctImage@TypeHint" value="nt:file" />
                        </fieldset>
                        <input type="hidden" name=":redirect" value="/content/contactsapp.html" />
                        
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    
</div>
    <!-- JavaScrip Search Plugin -->
    <script src="https://rawgithub.com/stidges/jquery-searchable/master/dist/jquery.searchable-1.0.0.min.js"></script>
    <script src="https://raw.github.com/jonnyreeves/jquery-Mustache/master/jquery.mustache.js"></script>
	<script src="https://raw.github.com/janl/mustache.js/master/mustache.js"></script>                        
</body>
</html>