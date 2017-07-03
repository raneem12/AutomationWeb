<%--
  Created by IntelliJ IDEA.
  User: rzzayed
  Date: 7/2/17
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="TESTJS.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">

            <form action="hi" >
                <table class="table table-bordered table-hover" >

                    <tbody id="tab_logic">
                    <tr>
                        <td>
                            <%--<div class="dropdown">--%>
                            <%--<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">--%>
                            <%--<span class="caret"></span></button>--%>
                            <%--<ul  name="action0" class="dropdown-menu">--%>
                            <%--<li><a href="#">Navigate</a></li>--%>
                            <%--<li><a href="#">getText</a></li>--%>
                            <%--<li><a href="#">validate</a></li>--%>
                            <%--<li><a href="#">param</a></li>--%>
                            <%--<li><a href="#">form</a></li>--%>

                            <%--</ul>--%>
                            <%--</div>--%>


                                <select  name = "action0" class="form-control">
                                    <option>Navigate</option>
                                    <option>ClickLink</option>
                                </select>
                        </td>
                        <td>
                            <input type="text"  name="value0" placeholder='value' class="form-control"/>
                        </td>
                        <td>
                            <input type="text"  placeholder='id' class="form-control"/>
                        </td>
                        <td>
                            <input type="text"  placeholder='type' class="form-control"/>
                        </td>
                        <td>
                            <input type="text"  placeholder='name' class="form-control"/>
                        </td>

                    </tr>

                    </tbody>

                </table>
                <a  class="btn btn-default pull-left" onclick="insRow()">Add Row</a>
                <button type="submit" value="submit" ></button>
            </form>
        </div>

    </div>


</div>
</body>
</html>