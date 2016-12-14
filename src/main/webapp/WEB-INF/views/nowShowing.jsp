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
                                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#movie-info" data-moviename="${movie.name}" data-cast="${movie.cast}" data-plot='${movie.plot}' data-language="${movie.lang}">
                                                <i class="fa fa-info-circle" aria-hidden="true"></i> More Info</button>
                                            <button type="button" class="btn btn-danger" style="min-height: 45px; max-height: 45px" data-toggle="modal" data-target="#movie-trailer" data-source="https://www.youtube.com/v/${movie.trailerId}&amp;autoplay=1" data-mvtitle="${movie.name}"><i class="fa fa-youtube-play fa-2x" aria-hidden="true" style="font-size: 1.5em"></i></button>
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
                        <div class="well-sm"><mark><span id="title"></span></mark></div>
                        <h4>Language:</h4>
                        <div class="well-sm"><kbd id="lang"></kbd></div>
                        <h4>Cast:</h4>
                        <div class="well-sm" id="cast"></div>
                        <h4>Plot:</h4>
                        <div class="well-sm"><i id="plot"></i></div>
                    </div>
                    <div class="modal-footer ">
                        
                    </div>
                </div>
            </div>
            <!--modal-dialog-->
        </div>
        
        <div class="modal fade" id="movie-trailer" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="fa fa-times-circle" aria-hidden="true"></i></button>
                        <h4 class="modal-title" id="Heading">Movie Trailer</h4>
                    </div>                                                
                    <!--modal-content--> 
                    <div class="modal-body">
                        <iframe style="width:100%; height:100%;" frameborder="0" allowfullscreen=""></iframe>
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
              var language = button.data('language');


              var modal = $(this);
              modal.find('#cast').text(cast);
              modal.find('#plot').text(plot);
              modal.find('#title').text(moviename);
              modal.find('#lang').text(language);

            });
            
            $('#movie-trailer').on('show.bs.modal', function (event){
               var button = $(event.relatedTarget);
               var source = button.data('source');
               var title = button.data('mvtitle');
               
               var modal = $(this);
               modal.find('iframe').attr('src', source);
               modal.find('#Heading').text(title);
            });
            
            $('#movie-trailer').on('hidden.bs.modal', function () {
                var modal = $(this);
                modal.find('iframe').removeAttr('src');
            });
            
        });
    </script>
</t:Base>
