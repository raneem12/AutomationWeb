import com.atypon.automationframework.Main;
import com.atypon.automationframework.config.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 748495L;

    public static final String MY_DIR = "/home/rzzayed/Downloads/WebBasedAutomationFramework/myFiles";


    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        try {
            process(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        try {
            process(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException, SQLException, JAXBException {

        Scenario scenario = prepareXmlRoot(request);
        JAXBContext jaxbContext = JAXBContext.newInstance(Scenario.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(scenario, new File(MY_DIR + "/simple.xml"));
        jaxbMarshaller.marshal(scenario, System.out);

        Main.main(null);

    }

    private Scenario prepareXmlRoot(HttpServletRequest request) {
        Scenario scenario = new Scenario();
        TestCase testCase = null;

        int x = 0;
        String tempAction;
        String tempBy = null;
        List<Item> items = new ArrayList<>();
        List<Item> testcases = new ArrayList<>();
        Form form = null;
        Param param;
        while ((tempAction = request.getParameter("action" + x)) != null) {
            if (tempAction.equals("navigate")) {
                Navigate navigate1 = new Navigate();
                tempBy = request.getParameter("value" + x);
                navigate1.setUrl(tempBy);
                System.out.println(navigate1.getUrl());
                testCase.getItems().add(navigate1);

            } else if (tempAction.equals("clickLink")) {
                ClickLink clickLink = new ClickLink();
                clickLink.setName(tempBy);
                testCase.getItems().add(clickLink);
            } else if (tempAction.equals("form")) {
                form = new Form();
                form.setFormName(request.getParameter("name" + x));
                testCase.getItems().add(form);

            } else if (tempAction.equals("param")) {
                param = new Param();
                param.setId(request.getParameter("id" + x));

                param.setType(request.getParameter("type" + x));
                param.setValue(request.getParameter("value" + x));
                form.getParams().add(param);
            } else if (tempAction.equals("test")) {
                testCase = new TestCase();
                scenario.getTestCases().add(testCase);

            } else if (tempAction.equals("getText")) {
                GetText getText = new GetText();
                getText.setId(request.getParameter("id" + x));
                getText.setKey(request.getParameter("name" + x));
                testCase.getItems().add(getText);
            }
            else if (tempAction.equals("validateText")) {
                ValidateText validateText= new ValidateText();
                validateText.setValue(request.getParameter("value" + x));
                testCase.getItems().add(validateText);
            }

            x++;
        }


        return scenario;
    }
}
