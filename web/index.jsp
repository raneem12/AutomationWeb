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
    <h1 align="center">QA Testing Framework</h1>
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">

            <form action="hi" >

                <table class="table table-bordered table-hover" >

                    <tbody id="tab_logic" >

                    <tr >
                        <td>
                            <select  name = "action0" class="form-control " onchange="raneem(this)"  id="mid0">
                                <option></option>
                                <option value="navigate">Navigate</option>
                                <option value="clickLink">ClickLink</option>
                                <option value="getText">getText</option>
                                <option value="form" id="0">Form</option>
                                <option value="param">Param</option>
                                <option value="test">TestCase</option>


                            </select>
                        </td>

                        <td>
                            <input type="text"  id="id0" name="id0" placeholder='id' class="form-control"/>
                        </td>
                        <td>
                            <input  type="text"  id="value0" name="value0" placeholder='value' class="form-control"/>
                        </td>
                        <td>
                            <%-- <input type="text"  placeholder='type' class="form-control"/>--%>

                            <select  id = "type0" name = "type0" class="form-control">
                                <option>fillFromKeyboard</option>
                                <option>radio</option>
                                <option>getFromTestCase</option>
                                <option>dropdown</option>
                            </select>
                        </td>
                        <td>
                            <input type="text"   id="name0"  name="name0" placeholder='name' class="form-control"/>
                        </td>


                        <a  class="btn btn-default pull-left" id="testCase0" onclick="insTestCase()">+ New TestCase</a>

                    </tr>
                    <tr>
                        <td  id="hidden_div" style="display: none;">
                            <input type="text"  name="param0" placeholder='param' class="form-control"/>
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