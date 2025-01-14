package org.firstinspires.ftc.teamcode.tests.commands

import com.arcrobotics.ftclib.kinematics.wpilibkinematics.ChassisSpeeds
import org.firstinspires.ftc.teamcode.commands.TestDrive
import org.firstinspires.ftc.teamcode.subsystems.SwerveDriveBase
import org.junit.*
import org.mockito.kotlin.*
import java.util.function.DoubleSupplier

class TestDriveTests {

    @Test
    fun execute() {
        val forwardValue = 0.5;
        val chassisSpeeds = ChassisSpeeds(forwardValue, 0.0, 0.0)

        val leapfrogDriveBase = mock<SwerveDriveBase>()

        val testDrive = TestDrive(leapfrogDriveBase, DoubleSupplier { forwardValue })
        testDrive.execute()
        verify(leapfrogDriveBase).drive(argThat { this.vxMetersPerSecond == chassisSpeeds.vxMetersPerSecond })
    }
}