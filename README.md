This is an extension for the [RichUI Plugin Accordion](grails.org/plugin/RichUI#Accordion) to allow for pre-expansion of a selected section using an _expanded_ boolean attribute.

## Configuration ##
You need to tell the RichUI plugin that we have a replacement renderer for accordion (also see grails-app/conf/Config.groovy):

    // richui config addition
    richui.accordionItemRenderer="ExpandableAccordionItemRenderer"

## Renderer ##
Drop into src/groovy

## GSP example ##

    <resource:accordion skin="custom" />
    <div id="summary_left">
        <div class="country_select">
            <div class="panel_head2">Select Country</div>
            <br /><br />
            <richui:accordion>
                <g:each in="${regionInstanceList}" status="i" var="regionInstance">
                    <richui:accordionItem id="${regionInstance.regionName}" caption="${regionInstance.regionName}" 
                      expanded="${regionInstance.regionName == selectedRegionName}">
                        <g:each var="rc" in="${regionInstance.countries}">
                            <g:set var="countryId" value="${rc.country.id}"/>
                            <g:link controller="${controller}" action="${action}" params="[country_id:countryId]">
                                ${rc.country?.encodeAsHTML()}
                            </g:link><br/>
                        </g:each>					    
                    </richui:accordionItem>
                </g:each>
            </richui:accordion>				
        </div>
    </div>	

In this case the controller has used a query string parameter to pre-expand a section if the user has selected one...

    } else if(params.regionName) {
		selectedRegionName = params.regionName
