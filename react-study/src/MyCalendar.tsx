import React from 'react';
import * as moment from 'moment';
import { Moment } from 'moment';
import { extendMoment } from 'moment-range';

const extendedMoment = extendMoment(moment);

function generateCalendar(currentDate: Moment): Moment[] {
    const startMonth = extendedMoment(currentDate).startOf('month');
    const endMonth = extendedMoment(currentDate).endOf('month');

    const range = extendedMoment.range(
        startMonth.startOf('week'),
        endMonth.endOf('week')
    );

    return Array.from(range.by('day'));
}

function MyCalendar(): JSX.Element {
    const [currentDate, setCurrentDate] = React.useState<Moment>(extendedMoment());

    const calendarDays = generateCalendar(currentDate);

    return (
        <div>
            <h2>{currentDate.format('MMMM YYYY')}</h2>
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(7, 1fr)', gap: '10px' }}>
                {['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'].map(day => (
                    <div key={day} style={{ fontWeight: 'bold', textAlign: 'center' }}>{day}</div>
                ))}
                {calendarDays.map((day, index) => (
                    <div
                        key={index}
                        style={{
                            padding: '10px',
                            backgroundColor: day.isSame(currentDate, 'month') ? '#fff' : '#e0e0e0',
                            textAlign: 'center',
                            border: day.isSame(extendedMoment(), 'day') ? '2px solid #000' : '1px solid #ccc',
                        }}
                    >
                        {day.format('D')}
                    </div>
                ))}
            </div>
        </div>
    );
}

export default MyCalendar;