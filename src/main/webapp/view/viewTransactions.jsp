<html>
<head>
    <title>
        Banking App
    </title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#fromDate" ).datepicker();
            $("#toDate").datepicker();
        } );
    </script>

</head>
<body>
Select date range
<form action="../view-transactions">
    <table>
        <thead>

        </thead>
        <tbody>
        <tr>
            <td>
               From Date : <p>Date: <input type="text" id="fromDate" name="fromDate" required></p>
            </td>
            <td>
                To Date : <p>Date: <input type="text" id="toDate" name="toDate" required></p>
            </td>
        </tr>
        <tr>
            <td colspan="2"><td>
            <input type="submit" value="Show">
        </td></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>