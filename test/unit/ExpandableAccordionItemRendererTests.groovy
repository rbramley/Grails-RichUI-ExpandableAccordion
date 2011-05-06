import grails.test.*

class ExpandableAccordionItemRendererTests extends GrailsUnitTestCase {
    def renderer
    def body
	
	protected void setUp() {
        super.setUp()
        renderer = new ExpandableAccordionItemRenderer()
		body = { 'hi'}		
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testExpandedTrue() {
    	def attrs = [id:'abc', caption:'abc', expanded:true]
    	def res = renderer.renderTag(attrs, body)
    	assertTrue res.contains('expand')
    }

    void testExpandedFalse() {
    	def attrs = [id:'abc', caption:'abc', expanded:false]
    	def res = renderer.renderTag(attrs, body)
    	assertFalse res.contains('expand')
    }

    void testUnexpanded() {
    	def attrs = [id:'abc', caption:'abc']
    	def res = renderer.renderTag(attrs, body)
    	assertFalse res.contains('expand')
    }
}
