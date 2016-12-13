<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:Base title="My Popcorn - Now Showing">
    <div class="container" style="padding-top: 90px">
        
        <div class="container">
            <div class="row">
                <c:forEach items="${movies}" var="movie">
                    <div class="col-md-4 col-sm-6 col-xs-12">
                        <div class="panel panel-primary">
                            <div class="panel-heading text-center">
                                ${movie.name}
                            </div>
                            <div class="vertical-center">
                                <div class="container">
                                    <div class="panel-body text-center" style="max-height: 435px; min-height: 435px">
                                        <img src="http://tgv.static.appxtream.com/${movie.posterURL}" width="230">
                                        <hr>
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#movie-info" data-moviename="${movie.name}" data-cast="${movie.cast}" data-plot="${movie.plot}">
                                                <i class="fa fa-info-circle" aria-hidden="true"></i> More Info</button>
                                            <button type="button" class="btn btn-danger" style="min-height: 45px; max-height: 45px"><i class="fa fa-youtube-play fa-2x" aria-hidden="true" style="font-size: 1.5em"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        
        
        <div class="modal fade" id="movie-info" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="fa fa-times-circle" aria-hidden="true"></i></button>
                        <h4 class="modal-title" id="Heading">Movie Details</h4>
                    </div>                                                
                    <!--modal-content--> 
                    <div class="modal-body">
                        <h4>Title:</h4>
                        <mark><span id="title"></span></mark>
                        <h4>Cast:</h4>
                        <span id="cast"></span>
                        <h4>Plot:</h4>
                        <span id="plot"></span>
                    </div>
                    <div class="modal-footer ">
                        
                    </div>
                </div>
            </div>
            <!--modal-dialog-->
        </div>
        

    </div>
    <script>
        $(document).ready(function () {
            $('#movie-info').on('show.bs.modal', function (event) { // id of the modal with event
              var button = $(event.relatedTarget); // Button that triggered the modal
              var cast = button.data('cast'); // Extract info from data-* attribute
              var plot = button.data('plot');
              var moviename = button.data('moviename');

              // Update the modal's content.
              var modal = $(this);
              modal.find('#cast').html('<i>'+cast+'</i>');
              modal.find('#plot').html('<i>' + plot + '</i>');
              modal.find('#title').text(moviename);

              // And if you wish to pass the productid to modal's 'Yes' button for further processing
              //modal.find('button.btn-warning').val(username);
            });
        });
    </script>
</t:Base>
