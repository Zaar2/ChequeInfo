package com.zaar.chequeinfo.views.fragment.mainMenu

import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.zaar.chequeinfo.R
import com.zaar.chequeinfo.views.activity.MainActivity
import com.zaar.chequeinfo.views.fragment.cheques.ChequesFragment
import com.zaar.chequeinfo.views.fragment.goods.GoodsFragment
import com.zaar.chequeinfo.views.fragment.information.InformationFragment
import com.zaar.chequeinfo.views.fragment.sellers.SellersFragment
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInfo
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainMenuFragmentTest {

    @JvmField
    @Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private var navController: TestNavHostController? = null
//        TestNavHostController(ApplicationProvider.getApplicationContext())

    private inline fun <reified T : Fragment>testFragmentsBackToMainMenu(){
        navController?.let { navController ->
            launchFragmentInContainer<T>().onFragment { fragment ->
                navController.setGraph(R.navigation.nav_host_graph_main)
                Navigation.setViewNavController(fragment.requireView(), navController)
            }
        }
        onView(ViewMatchers.withId(R.id.btnBack))
            .perform(ViewActions.click())
        assertEquals(
            R.id.mainMenuFragment2,
            navController?.currentDestination?.id
        )
    }



    @Before
    fun beforeTest(testInfo: TestInfo) {
        println("${testInfo.testMethod.get().name}() - prepare")
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        navController?.let { navController ->
            launchFragmentInContainer<MainMenuFragment>().onFragment { fragment ->
                navController.setGraph(R.navigation.nav_host_graph_main)
                Navigation.setViewNavController(fragment.requireView(), navController)
            }
        }
        println("${testInfo.testMethod.get().name}() - start")
    }

    @Test
    fun testNavMainToGoodsAndBack() {
        onView(ViewMatchers.withId(R.id.tv_labelGoods_uploadActivity)).check(matches(ViewMatchers.withText("")))
        onView(ViewMatchers.withId(R.id.btnMain_goods)).perform(ViewActions.click())
        assertEquals(
            R.id.goodsFragment,
            navController?.currentDestination?.id
        )
        testFragmentsBackToMainMenu<GoodsFragment>()
    }

    @Test
    fun testNavMainToInfAndBack() {
        onView(ViewMatchers.withId(R.id.btnMain_information)).perform(ViewActions.click())
        assertEquals(
            R.id.informationFragment,
            navController?.currentDestination?.id
        )
        testFragmentsBackToMainMenu<InformationFragment>()
    }

    @Test
    fun testNavMainToSellersAndBack() {
        onView(ViewMatchers.withId(R.id.btnMain_sellers)).perform(ViewActions.click())
        assertEquals(
            R.id.sellersFragment,
            navController?.currentDestination?.id
        )
        testFragmentsBackToMainMenu<SellersFragment>()
    }

    @Test
    fun testNavMainToChequesAndBack() {
        onView(ViewMatchers.withId(R.id.btnMain_cheques)).perform(ViewActions.click())
        assertEquals(
            R.id.chequesFragment,
            navController?.currentDestination?.id
        )
        testFragmentsBackToMainMenu<ChequesFragment>()
    }
}